package kr.co.kmarket.admin.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kmarket.admin.service.AdminProductService;
import kr.co.kmarket.vo.ProductCate1Vo;
import kr.co.kmarket.vo.ProductCate2Vo;
import kr.co.kmarket.vo.ProductVo;

@Controller
public class AdminProductController {

	@Autowired
	private AdminProductService service;
	
	@GetMapping("/admin/product/list")
	public String list() {
		return "/admin/product/list";
	}
	
	@GetMapping("/admin/product/register")
	public String register() {
		return "/admin/product/register";
	}
	
	@PostMapping("/admin/product/register")
	public String register(ProductVo vo, HttpServletRequest req) {
		
		vo.setIp(req.getRemoteAddr());
		
		// 썸네일 이미지 업로드
		vo = service.fileUpload(vo);
		
		// 상품 정보 INSERT
		service.insertProduct(vo);
		
		return "/admin/product/register";
	}
	
	@ResponseBody
	@GetMapping("/admin/product/getCate1")
	public List<ProductCate1Vo> getCate1() {
		List<ProductCate1Vo> cate1s = service.selectCate1();
		return cate1s;
	}
	
	@ResponseBody
	@GetMapping("/admin/product/getCate2")
	public List<ProductCate2Vo> getCate2(int cate1) {
		List<ProductCate2Vo> cate2s = service.selectCate2(cate1);
		return cate2s;
	}
	
}