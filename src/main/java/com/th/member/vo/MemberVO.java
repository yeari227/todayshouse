package com.th.member.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;

import com.th.member.validator.MemberValidator;

public class MemberVO {

	@Value("M_EMAIL")
	@NotEmpty(message="이메일은 필수 입력 값입니다."
			  , groups={MemberValidator.Regist.class, MemberValidator.Login.class})
	@Email(message="이메일형식으로 작성해주세요."
			, groups= {MemberValidator.Regist.class, MemberValidator.Login.class})
	private String email;

	@NotEmpty(message="이름은 필수 입력 값입니다.", groups= {MemberValidator.Regist.class})
	private String name;
	
	@NotEmpty(message="비밀번호는 필수 입력 값입니다."
			 , groups={MemberValidator.Regist.class, MemberValidator.Login.class})
	/*@Length(min=8, max=20, message="비밀번호는 8~20글자 사이로 입력해주세요."
			 , groups={MemberValidator.Regist.class})	*/			// 로그인에도 length msg를 준다면 해커에게 힌트를 주는 격
	@Pattern(regexp="((?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*()]).{8,})"
			 , groups={MemberValidator.Regist.class})
	private String password;
	private String salt;
	
	private int point;
	private boolean chatOk;
	private String lastLogin;
	private int loginFailCount;
	private int deleteArtCount;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public boolean isChatOk() {
		return chatOk;
	}

	public void setChatOk(boolean chatOk) {
		this.chatOk = chatOk;
	}

	public String getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public int getLoginFailCount() {
		return loginFailCount;
	}

	public void setLoginFailCount(int loginFailCount) {
		this.loginFailCount = loginFailCount;
	}

	public int getDeleteArtCount() {
		return deleteArtCount;
	}

	public void setDeleteArtCount(int deleteArtCount) {
		this.deleteArtCount = deleteArtCount;
	}

	@Override
	public String toString() {
		return "MemberVO [email=" + email + ", name=" + name + ", password=" + password + ", salt=" + salt + ", point="
				+ point + ", chatOk=" + chatOk + ", lastLogin=" + lastLogin + ", loginFailCount=" + loginFailCount
				+ ", deleteArtCount=" + deleteArtCount + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
