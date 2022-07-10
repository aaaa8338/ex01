package egovframework.example.sample.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.sample.service.MemberService;
import egovframework.example.sample.service.MemberVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service
public class MemberServiceImpl extends EgovAbstractServiceImpl implements MemberService {
	
	/** MemberDAO */
	// ibatis 사용
	@Resource
	private MemberDAO memberDao;
	
	
	/**
	 * 회원 목록을 조회한다.
	 * @param MemberVO - 조회할 정보가 담긴 VO
	 * @return 회원 목록
	 * @exception Exception
	 */
	@Override
	public List<Map <String, Object>> selectMember(Map <String, Object> map) throws Exception {
		return memberDao.selectMember(map);
	}
	
	/**
	 * 로그인 체크를한다.
	 * @param String - 조회할 정보가 담긴 id, password
	 * @return true / false 
	 * @exception Exception
	 */
	@Override
	public Boolean loginCheck(String id, String password) throws Exception {
		return memberDao.loginCheck(id, password);
	}
	
	/**
	 * 회원을 등록한다
	 * @param vo - 등록할 정보가 담긴 MemberVO
	 * @return String형
	 * @exception Exception
	 */
	@Override
	public String insertMember(MemberVO vo) throws Exception {
		return memberDao.insertMember(vo);
	}

	/**
	 * 회원가입시 아이디 체크를 한다.
	 * @param String - 조회할 정보가 담긴 id
	 * @return int 
	 * @exception Exception
	 */
	@Override
	public int idCheck(String id) throws Exception {
		return memberDao.idCheck(id);
	}


}
