package com.portfolio.www.dao;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class JoinDao extends JdbcTemplate {
	
	public JoinDao() {}
	public JoinDao(DataSource dataSource) {
		super(dataSource);
		System.out.println("\n\n"+dataSource);
	}
	
			
	public int join(HashMap<String, String> params) {
		String sql ="INSERT INTO forum.`member` "
				+ "(member_id, passwd, member_nm, email, auth_yn, pwd_chng_dtm, join_dtm) "
				+ "VALUES('"+params.get("memberId")
				+ "', '"+params.get("passwd")
				+ "', '', '"+params.get("email")
				+ "', '', '', DATE_FORMAT(NOW(), '%Y%m%d%H%i%s'))";
	return update(sql);  //jdbcTemplete 메서드   //select 외에 3개는 row가 변한 개수 알려줌 
	//joinDao는 datasource를 받아와서 jdbc에 넘겨야
	}
	

}
