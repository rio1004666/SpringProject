package kr.co.thejoenmovie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.thejoenmovie.service.MainService;
import kr.co.thejoenmovie.vo.MovieVo;

@Controller
public class MainController {

	@Autowired
	private MainService service;
	
	@GetMapping(value = {"/", "/index"})
	public String index(Model model,String search,String success) {
		
		if(search == null && success == null) {
			
		}else if(search != null && success == null){
			model.addAttribute("search", search);
			
			
		}else if(search == null && success != null){
			model.addAttribute("success", success);
			
			
		}
		List<MovieVo> movieinfo = service.selectMovieInfo();
		
		model.addAttribute("movieinfo", movieinfo);
		return "/index";
	}
	
	@GetMapping("/view_movie")
	public String view(Model model, MovieVo vo){
		MovieVo movie =  service.MovieInfo(vo);
		if(movie != null) {
			model.addAttribute("movie", movie);
			
			return "/view_movie";
		}else {
			return "redirect:/index?search=101";
		}
		
	}
	
	@GetMapping("/view_total_movie")
	public String total_movie(Model model, String pg){
		
		int currentPage = service.getCurrentPage(pg);
		int start = service.getLimitStart(currentPage);
		int total = service.selectCountTotal();
		int pageStartNum = service.getPageStartNum(total, start);
		int lastPageNum = service.getLastPageNum(total);
		int groups[] = service.getPageGroup(currentPage, lastPageNum);
		
		List<MovieVo> allmovie = service.selectAllMovies(start);
		
		model.addAttribute("allmovie", allmovie);
		model.addAttribute("pageStartNum", pageStartNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPageNum", lastPageNum);
		model.addAttribute("groups", groups);
		
		return "/view_total_movie";
	}
	
	@GetMapping("/book_ticket")
	public String book_ticket(Model model,String title){
		model.addAttribute("title",title);
		return "/book_ticket";
	}
	@GetMapping("/view_event")
	public String event(){
		return "/view_event";
	}
	@ResponseBody
	@PostMapping("/goTicket")
	public String goTicket(Model model,String title) {
		
		
		JsonObject json = new JsonObject();
		json.addProperty("result", title);
		return new Gson().toJson(json);
	}
}