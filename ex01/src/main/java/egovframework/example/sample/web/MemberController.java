package egovframework.example.sample.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import egovframework.example.sample.service.MemberService;
import egovframework.example.sample.service.MemberVO;

@Controller
public class MemberController {
	
	@Resource
	private MemberService memberService;
	
	/**
	 * 회원가입 페이지로 이동
	 * @param 
	 * @return "member/join.do"
	 * @exception Exception
	 */
	@RequestMapping("join.do")
	public String join() {
		return "member/join";
	}
	
	@RequestMapping("memberList.do")
	public String memberList() {
		return "member/memberList";
	}
	
	@RequestMapping("selectMember.do")
	public ModelAndView selectMember(Map <String, Object> map) throws Exception{
		ModelAndView mav = new ModelAndView();
		List<Map <String, Object>> ListMap = memberService.selectMember(map);
		
		mav.setViewName("member/memberList");
		mav.addObject("list", ListMap);
		
		return mav;
	}
	
	/**
	 * 회원을 등록한다.
	 * @param MemberVO - 등록할 정보가 담긴 VO
	 * @return string
	 * @exception Exception
	 */
	@RequestMapping("insertMember.do")
	@ResponseBody
	public String insertMember(MemberVO vo, ModelMap model) throws Exception{
		int cnt = memberService.idCheck(vo.getId());
		System.out.println(cnt);
		System.out.println(vo.isConfirmPassword());

		String result = "";
		
		if (cnt != 1) {
			memberService.insertMember(vo);
			result = "success";
		} 
		
		return result;
	}
	
	/**
	 * 로그인 체크
	 * @param 
	 * @return "member/join.do"
	 * @exception Exception
	 */
	@RequestMapping("loginCheck.do")
	@ResponseBody
	public String loginCheck (@ModelAttribute MemberVO vo) throws Exception {
//		boolean result = memberService.loginCheck(vo.getId(), vo.getPwd()); 
		
		return "/";
	}
}
