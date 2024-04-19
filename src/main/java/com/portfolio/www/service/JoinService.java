package com.portfolio.www.service;

import java.util.HashMap;

import com.portfolio.www.dao.JoinDao;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class JoinService {
	
	private JoinDao joinDao;
	public void setJoinDao(JoinDao joinDao) {
		System.out.println("\n\n joinDao: "+joinDao+"in joinService \n\n");
		this.joinDao = joinDao;
	}
		
		
		public int join(HashMap<String, String> params) {
			String passwd = params.get("passwd");
			String encPasswd = BCrypt.withDefaults().hashToString(12, passwd.toCharArray());
			System.out.println("encPasswd >>>>>>>>> " + encPasswd);
			BCrypt.Result result = BCrypt.verifyer().verify(passwd.toCharArray(), encPasswd);
			System.out.println("result.verified >>>>>>> " + result.verified);
			
			params.put("passwd", encPasswd);
			return joinDao.join(params);
		}
	
	
}
