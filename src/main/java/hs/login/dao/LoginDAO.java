package hs.login.dao;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;

import hs.login.dto.LoginDTO;

@Repository
public class LoginDAO {
	@Inject
	SqlSessionTemplate template;

	public LoginDTO loginProcess(LoginDTO loginDTO) {
		return template.selectOne("loginProcess", loginDTO);
	}

	public LoginDTO idFindProcess(LoginDTO loginDTO) {
		return template.selectOne("idFindProcess", loginDTO);
	}

	public LoginDTO pwFindProcess(LoginDTO loginDTO) {
		return template.selectOne("pwFindProcess", loginDTO);
	}

	// ????
	public int setPw(LoginDTO loginDTO) {
		return template.update("setPw", loginDTO);
	}
}
