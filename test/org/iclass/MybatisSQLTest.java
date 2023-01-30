package org.iclass;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.iclass.dao.NewMemberMybatisDao;
import org.iclass.vo.NewMember;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import mybatis.SqlSessionBean;

class MybatisSQLTest {

	private NewMemberMybatisDao dao = NewMemberMybatisDao.getInstance();
	
	@Order(2)
	@DisplayName("SqlSession 연결 테스트")
	@Test
	void session() {
		SqlSession mapper = SqlSessionBean.getSession();
		assertNotEquals(mapper, null);
		mapper.close();
	}
	@Order(1)
	@DisplayName("select 전체 조회 테스트 - 현재 예상값 = 4")
	@Test
	void selectList() {
		assertEquals(dao.selectAll().size(), 4);
	}
	
	@Order(3)
	@DisplayName("insert 테스트 - id(PK):momo로 추가") // 첫번째 테스트는 성공, 두번째 테스트는 실패
	@Test
	void insert() {
		int result = dao.insert(NewMember.builder().
				id("momo").name("이모모").password("1212").email("momo@naver.com").age(12).gender("2").hobbies("달리기").build());
		assertEquals(result, 1);
	}
	@Order(4)
	@DisplayName("selectOne 테스트 ") // 첫번째 테스트는 성공, 두번째 테스트는 실패
	@Test
	void selectOne() {
		assertEquals(dao.selectOne("momo"), null);
		//assertEquals(dao.selectOne("momo").getName(),"이모모");
	}
	
	@Test
	@DisplayName("login 테스트")
	@Order(5)
	void login() {
		String id = "momo";
		String password = "1212";
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("id", id);								// map <"id", momo>
		map.put("password", password);					// map <"password", 1212>
		NewMember vo = dao.login(map);
		
		// System.out.println(dao.login(map));		// 담겼는지 확인용 (담겼으면 (쿼리문사용한)id, name, email이 표기됨.)
		assertNotNull(vo.getId());
		
	}
}





