package kr.co.thejoenmovie.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.thejoenmovie.service.MemberService;
import kr.co.thejoenmovie.vo.MemberVo;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	@GetMapping("/member/login")
	public String login(Model model,String success){
		
		model.addAttribute("success",success);
		
		
		return "/member/login";
	}
	@PostMapping("/member/login")
	public String login(HttpSession sess, MemberVo mv) {
		MemberVo sessMember = service.selectMember(mv);
		if(sessMember != null) {
			sess.setAttribute("sessMember", sessMember);
			return "redirect:/index?success=100";
		}else {
			return "redirect:/member/login?success=101";
		}
		
	}
	@GetMapping("/member/terms")
	public String terms(){
		return "/member/terms";
	}
	@GetMapping("/member/register")
	public String register(){
		return "/member/register";
	}
	@PostMapping("/member/register")
	public String register(MemberVo mv) {
		
		service.insertMember(mv);
		
		
		return "/index";
	}
	@ResponseBody
	@GetMapping("/member/checkUid")
	public String checkUid(String uid) {
	
		int result = service.selectCountUid(uid);
	
	
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
	
		return new Gson().toJson(json);
	}
	
	@ResponseBody
	@GetMapping("/member/checkNick")
	public String checkNick(String nick) {
	
		int result = service.selectCountNick(nick);
		
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		return new Gson().toJson(json);
	}
	
	@ResponseBody
	@GetMapping("/member/checkEmail")
	public String checkEmail(String email) throws JsonProcessingException {
	
		int result = service.selectCountEmail(email);
		// Jackson 라이브러리로 json생성
		Map<String, Integer> resultMap = new HashMap<>();
		resultMap.put("result", result);
		String strJson = new ObjectMapper().writeValueAsString(resultMap);
		return strJson;
	}
	
	@ResponseBody
	@GetMapping("/member/checkHp")
	public String checkHp(String phone) throws JsonProcessingException {
	
		int result = service.selectCountHp(phone);
		// Jackson 라이브러리로 json생성
		Map<String, Integer> resultMap = new HashMap<>();
		resultMap.put("result", result);
		String strJson = new ObjectMapper().writeValueAsString(resultMap);
		return strJson;
	}
	
}
