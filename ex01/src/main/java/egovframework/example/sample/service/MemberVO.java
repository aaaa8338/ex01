package egovframework.example.sample.service;

/**
 * @Class Name : MemberVO.java
 * @Description : MemberVO Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @            
 *
 * @author user
 * @since 2022.05.22
 *
 */

public class MemberVO {
	private String name;
	private String id;
	private String password;
	private String confirmPassword;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public boolean isConfirmPassword() {
		return password.equals(confirmPassword);
	}

	@Override
	public String toString() {
		return "MemberVO [name=" + name + ", id=" + id + ", password=" + password + ", confirmPassword="
				+ confirmPassword + "]";
	}

	
}
