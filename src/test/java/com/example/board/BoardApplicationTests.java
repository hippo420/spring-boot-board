package com.example.board;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardApplicationTests {

	//마이바티스 테스트
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Test
	public void testSqlSession() throws Exception{
		System.out.println("testSqlSession ==> ["+sqlSession.toString()+"]");
	}

	@Test
	void contextLoads() {
	}

}
