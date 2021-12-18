package kr.co.farmstory.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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

import kr.co.farmstory.service.MemberService;
import kr.co.farmstory.vo.MemberVo;
import kr.co.farmstory.vo.TermsVo;

@Controller
public class MemberController {

	@Autowired
	private MemberService service;

	@GetMapping("/member/login")
	public String login(String success, Model model) {
		model.addAttribute("success", success);
		return "/member/login";
	}

	@PostMapping("/member/login")
	public String login(HttpSession sess, String uid, String pass) {
		MemberVo mv = service.selectMember(uid, pass);
		if (mv != null) {
			sess.setAttribute("sessMember", mv);
			return "redirect:/index?success=104"; // 로그인에 성공했다는 플래그 
		} else {
			return "redirect:/member/login?success=100"; // 로그인에 실패했다는 플래그
		}

	}

	@GetMapping("/member/logout")
	public String logout(HttpSession sess) {
		// 현재 사용자 정보객체 세션삭제
		sess.invalidate();
		return "redirect:/member/login?success=102";
	}

	@GetMapping("/member/register")
	public String register() {
		return "/member/register";
	}

	@PostMapping("/member/register")
	public String register(HttpServletRequest req, MemberVo vo) {
		String regip = req.getRemoteAddr();
		vo.setRegip(regip);
		service.insertMember(vo);

		return "redirect:/member/login";
	}

	@GetMapping("/member/terms")
	public String terms(Model model) {
		TermsVo tv = service.selectTerms();
		model.addAttribute(tv);
		return "/member/terms";
	}

	@ResponseBody /*
					 * response객체에 json데이터를 출력해라 이걸 안하면 템플릿으로 포워딩된다. 원래 return값은 html 뷰페이지로
					 * 이동하는데....
					 *//* 자바객체를 HTTP요청의 바디내용으로 매핑하여 클라이언트로 전송 */
	@GetMapping("/member/checkUid")
	public String checkUid(String uid) {
		// System.out.println("uid: " + uid);

		int result = service.selectCountUid(uid);

		// System.out.println("result: " + result); 중간중간에 값이 제대로 들어왔는지 확인
		// jackson도 있고 gson도있지만 gson으로 선택하겟다

		JsonObject json = new JsonObject();
		json.addProperty("result", result);
		// 이 메서드는 json객체를 반환하기 때문에 어노테이션을 추가해야한다. 그게 바로 responsebody어노테이션
		return new Gson().toJson(json);// 리턴값이 없으면 에러난다.
	}

	@ResponseBody
	@GetMapping("/member/checkNick")
	public String checkNick(String nick) {

		int result = service.selectCountNick(nick);

		// Gson라이브러리로 json 생성(라이브러리 추가해야함)
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
	public String checkHp(String hp) throws JsonProcessingException {

		int result = service.selectCountHp(hp);
		// Jackson 라이브러리로 json생성
		Map<String, Integer> resultMap = new HashMap<>();
		resultMap.put("result", result);
		String strJson = new ObjectMapper().writeValueAsString(resultMap);
		return strJson;
	}
}
