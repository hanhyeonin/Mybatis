package org.iclass.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.NewMember;

import mybatis.SqlSessionBean;

public class NewMemberMybatisDao {

	private static final NewMemberMybatisDao dao = new NewMemberMybatisDao();
	private NewMemberMybatisDao() {}
	public static NewMemberMybatisDao getInstance() {
		return dao;
	}
	
	// Exception 처리 필요없음. 객체와 db컬럼 매핑 필요 없음. 리스트 add 필요없음.
	public List<NewMember> selectAll(){
		SqlSession mapper = SqlSessionBean.getSession();
		List<NewMember> list = mapper.selectList("selectAll");
		
		mapper.close(); // 필수로 close할것. 
		return list;
	}
	
	public int insert(NewMember vo) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.insert("insert", vo);
		// Mybatis는 autocommit이 아닙니다.
		mapper.commit();
		mapper.close();
		return result;
	}
	
	public int update(NewMember vo) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.update("update",vo);
		
		mapper.commit();
		mapper.close();
		return result;
	}
	
	public int delete(String id) {
		SqlSession mapper = SqlSessionBean.getSession();
		int result = mapper.delete("delete",id);
		
		mapper.commit();
		mapper.close();
		return result;
	}
	
	public NewMember selectOne(String id) {
		SqlSession mapper = SqlSessionBean.getSession();
		NewMember vo = mapper.selectOne("selectOne", id);
		
		mapper.commit();
		mapper.close();
		return vo;
	}
	
	public NewMember login(Map<String, String> map){
		SqlSession mapper = SqlSessionBean.getSession();
		NewMember vo = mapper.selectOne("login",map);		// <"id",momo> <"password",1212>
		mapper.close();
		return vo;
	}
	
}
