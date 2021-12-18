package kr.co.kmarket.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.kmarket.service.MemberService;
import kr.co.kmarket.vo.MemberTermsVo;
import kr.co.kmarket.vo.MemberVo;

@Controller
public class MemberController {
	
	/* log는 사용자의 행동 정보를 모두 기록에 담아볼 수 있게 심어 놓는다. */
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	private MemberService service;
	
	///         회원가입              //////
	
	@GetMapping("/member/join")
	public String join() {
		logger.info("join....");
		
		return "/member/join";
	}
	//////////////   로그인  ///////////////////
	@GetMapping("/member/login")// int형으로 정하면 null값에러가 나서 String success로 해준다. 
	public String login(String productCode, String success, Model model) { // null값이 로그인 누를때 들어오는데 (파라미터 인자값없음) => 문자열타입으로 해줘야한다.
		
		
		logger.info("get-login....");
		// null값처리를 해줘야한다.
		model.addAttribute("productCode",productCode);
		model.addAttribute("success", success);
		
		return "/member/login";
		
	}
	@PostMapping("/member/login")
	public String login(MemberVo vo, HttpSession sess) {
		
		logger.info("post-login....");
		
		
		MemberVo memberVo = service.selectMember(vo);
		
		if(memberVo != null) {
			
			logger.info("get-login....1");
			
			sess.setAttribute("sessMember", memberVo);	
			
			if(vo.getProductCode() > 0) {
				
				return "redirect:/product/view?productCode="+vo.getProductCode();
				
			}else {
				return "redirect:/";
			}
		
		}else {
			
			logger.info("get-login....2");
			
			
			return "redirect:/member/login?success=101"; // 로그인에 실패했을 경우 
		}
	}
	@GetMapping("/member/logout")
	public String logout(HttpSession sess) {
		logger.info("logout....");
		
		sess.invalidate();
		return "redirect:/member/login?success=102"; // 로그아웃했을 경우 
	}
	
	///////////////////////////////////
	@GetMapping("/member/register")
	public String register() {
		logger.info("get-register....");
		return "/member/register";
	}
	
	
	@PostMapping("/member/register")
	public String register(HttpServletRequest req, MemberVo mv) {
		
		logger.info("post-register....");
		
		String ip = req.getRemoteAddr();
		mv.setIp(ip);
		
		//System.out.println("mv.type: " + mv.getType());
		
		
		
		service.insertMember(mv);
		return "redirect:/member/login";
	}
	
	////////////////////////////////////////////////////////////
	
	
	
	
	@GetMapping("/member/register-seller")
	public String registerSeller() {
		logger.info("get-registerSeller....");
		return "/member/register-seller";
	}
	@PostMapping("/member/register-seller")
	public String registerSeller(HttpServletRequest req, MemberVo vo) {
		logger.info("post-registerSeller....");
		String ip = req.getRemoteAddr();
		vo.setIp(ip);
		
		service.insertMember(vo);
		return "redirect:/member/login";
	}
	
	
	
	@GetMapping("/member/signup")
	public String signup(Model model,int type) {
		logger.info("signup....");
		MemberTermsVo termsVo = service.selectTerms();
		model.addAttribute("termsVo",termsVo);
		model.addAttribute("type",type);
		return "/member/signup";
	}
	
	
	@ResponseBody /*response객체에 json데이터를 출력해라 이걸 안하면 템플릿으로 포워딩된다. 원래 return값은 html 뷰페이지로 이동하는데....*//* 자바객체를 HTTP요청의 바디내용으로 매핑하여 클라이언트로 전송   */
	@GetMapping("/member/checkUid")
	public String checkUid(String uid) {
		//System.out.println("uid: " + uid);
		
		int result = service.selectCountUid(uid);
		
		//System.out.println("result: " + result); 중간중간에 값이 제대로 들어왔는지 확인 
		// jackson도 있고 gson도있지만 gson으로 선택하겟다 
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		// 이 메서드는 json객체를 반환하기 때문에 어노테이션을 추가해야한다. 그게 바로 responsebody어노테이션 
		return new Gson().toJson(json);// 리턴값이 없으면 에러난다.
	}
	@ResponseBody /*response객체에 json데이터를 출력해라 이걸 안하면 템플릿으로 포워딩된다. 원래 return값은 html 뷰페이지로 이동하는데....*//* 자바객체를 HTTP요청의 바디내용으로 매핑하여 클라이언트로 전송   */
	@GetMapping("/member/checkEmail")
	public String checkEmail(String email) {
		//System.out.println("uid: " + uid);
		
		int result = service.selectCountEmail(email);
		
		//System.out.println("result: " + result); 중간중간에 값이 제대로 들어왔는지 확인 
		// jackson도 있고 gson도있지만 gson으로 선택하겟다 
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		// 이 메서드는 json객체를 반환하기 때문에 어노테이션을 추가해야한다. 그게 바로 responsebody어노테이션 
		return new Gson().toJson(json);// 리턴값이 없으면 에러난다.
	}
	@ResponseBody /*response객체에 json데이터를 출력해라 이걸 안하면 템플릿으로 포워딩된다. 원래 return값은 html 뷰페이지로 이동하는데....*//* 자바객체를 HTTP요청의 바디내용으로 매핑하여 클라이언트로 전송   */
	@GetMapping("/member/checkHp")
	public String checkHp(String hp) {
		//System.out.println("uid: " + uid);
		
		int result = service.selectCountHp(hp);
		
		//System.out.println("result: " + result); 중간중간에 값이 제대로 들어왔는지 확인 
		// jackson도 있고 gson도있지만 gson으로 선택하겟다 
		
		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		// 이 메서드는 json객체를 반환하기 때문에 어노테이션을 추가해야한다. 그게 바로 responsebody어노테이션 
		return new Gson().toJson(json);// 리턴값이 없으면 에러난다.
	}
	
	
	
	
	
	
	
	
	
}
