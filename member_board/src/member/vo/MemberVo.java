package member.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class MemberVo {
	private final String id;
	private final String pwd;
	private final String name;
	private final String email;
	private final Date joinDate;
}
