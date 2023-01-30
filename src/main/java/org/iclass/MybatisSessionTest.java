package org.iclass;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.iclass.dao.NewMemberMybatisDao;
import org.iclass.vo.NewMember;

import mybatis.SqlSessionBean;

public class MybatisSessionTest {
	
	public static void main(String[] args) {
		
		SqlSession mapper = SqlSessionBean.getSession();
		
		if(mapper == null)
			System.out.println("mybatis 설정에 오류가 있습니다.");
		else
			System.out.println(mapper);
		mapper.close();
		
		NewMemberMybatisDao dao = NewMemberMybatisDao.getInstance();
		List<NewMember> list = new ArrayList<NewMember>();
		list = dao.selectAll();
		for (NewMember m : list) {
			System.out.println(m);
		}
		
	}
}
