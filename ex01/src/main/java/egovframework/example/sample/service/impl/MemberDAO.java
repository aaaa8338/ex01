package egovframework.example.sample.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import egovframework.example.sample.service.MemberVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository
public class MemberDAO extends EgovAbstractDAO{
	
	
	/**
	 * 회원 목록을 조회한다.
	 * @param MemberVO - 조회할 정보가 담긴 VO
	 * @return 회원 목록
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	List<Map <String, Object>> selectMember(Map <String, Object> map) throws Exception {
		return (List<Map<String, Object>>) list("MemberDAO.selectMember", map);
	}
	
	
	/**
	 * 회원을 등록한다
	 * @param vo - 등록할 정보가 담긴 MemberVO
	 * @return String형
	 * @exception Exception
	 */
	String insertMember(MemberVO vo) throws Exception {
		return (String)insert("MemberDAO.insertMember", vo);
	}
	
	
	/**
	 * 회원가입시 아이디 체크를 한다.
	 * @param String - 조회할 정보가 담긴 id
	 * @return Integer 
	 * @exception Exception
	 */
	int idCheck(String id) throws Exception {
		return (int) select("MemberDAO.idCheck", id);
	};
	
	
	/**
	 * 로그인 체크를 한다.
	 * @param String - 조회할 정보가 담긴 id, password
	 * @return true / false 
	 * @exception Exception
	 */
	Boolean loginCheck(String id, String password) throws Exception {
		boolean result = true;
				
		// 전달할 값이 2개 이상인 경우 VO 또는 맵으로 전달
		Map<String,String> map = new HashMap<>();
		
		map.put("id", id);
		map.put("password", password);
		
		int count = (int)select("MemberDAO.loginCheck", map);
		//레코드가 1개이면 true, 0개이면 false (리턴)
		if (count == 1) result = false;
		
		return result;
	}

	
}
