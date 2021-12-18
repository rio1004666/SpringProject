package kr.co.thejoenmovie.vo;

import lombok.Data;

@Data
public class MemberVo {
	private String uid;
	private String pass;
	private String name;
	private String nick;
	private String email;
	private String phone;
	private String path;
	private String reco;
}
