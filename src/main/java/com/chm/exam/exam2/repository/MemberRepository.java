package com.chm.exam.exam2.repository;

import com.chm.exam.exam2.dto.Member;
import com.chm.mysqlutil.MysqlUtil;
import com.chm.mysqlutil.SecSql;

public class MemberRepository {

	public Member getMemberByLoginId(String loginId) {
		SecSql sql = new SecSql();
		sql.append("SELECT M.*");
		sql.append("FROM member AS M");
		sql.append("WHERE M.loginId = ?", loginId);

		return MysqlUtil.selectRow(sql, Member.class);
	}

}
