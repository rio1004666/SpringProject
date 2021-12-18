package kr.co.kmarket.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.service.MainService;
import kr.co.kmarket.vo.CategoriesVo;
import kr.co.kmarket.vo.ProductVo;

@Controller
public class MainController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	
	@Autowired
	private MainService service;
	
	@GetMapping(value={"/","/index"})
	public String index(Model model) {
		
		
		
		logger.info("MainController - index");
		
		
		
		// 이렇게 하면 일일이 각 상품리스트에 넣어주어야한다.............
//		List<CategoriesVo> cates= service.selectCategories();
//		model.addAttribute("cates", cates);
		List<ProductVo> productsHit = service.selectMainProduct("hit");
		
		List<ProductVo> productsBest = service.selectMainProduct("sold");
		for(ProductVo product : productsBest) {
			System.out.println(product.getProductCode());
		}
		//List<ProductVo> productsRecommend = service.selectMainProduct("score");
		//List<ProductVo> productsLatest = service.selectMainProduct("rdate");
		//List<ProductVo> productsDiscount = service.selectMainProduct("discount");
		
		model.addAttribute("productsHit",productsHit);
		model.addAttribute("productsBest",productsBest);
		//model.addAttribute("productsRecommend",productsRecommend);
		//model.addAttribute("productsLatest",productsLatest);
		//model.addAttribute("productsDiscount",productsDiscount);
		
		
		return "/index";
	}
	@ResponseBody
	@GetMapping("/getCategories")
	public List<CategoriesVo> getCategories() {
		
		
		logger.info("MainController - getCategories");
		
		
		List<CategoriesVo> cates= service.selectCategories();
		// 알아서 json객체 리스트로 보내준다. 
		return cates;
	}
	@ResponseBody
	@GetMapping("/getMainProduct")
	public List<ProductVo> getMainProduct(String order) {
		
		logger.info("MainController - getMainProduct");
		
		
		List<ProductVo> products = service.selectMainProduct(order);
		return products;
	}
}
