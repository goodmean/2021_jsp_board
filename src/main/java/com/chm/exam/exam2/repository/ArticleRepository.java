package com.chm.exam.exam2.repository;

import java.util.List;

import com.chm.exam.exam2.dto.Article;
import com.chm.exam.exam2.util.Ut;
import com.chm.mysqlutil.MysqlUtil;
import com.chm.mysqlutil.SecSql;

public class ArticleRepository {
	public int write(String title, String body) {
		SecSql sql = new SecSql();
		sql.append("INSERT INTO article");
		sql.append("SET regDate = NOW()");
		sql.append(", updateDate = NOW()");
		sql.append(", title = ?", title);
		sql.append(", `body` = ?", body);
		
		int id = MysqlUtil.insert(sql);
		
		return id;
	}

	public List<Article> getForPrintArticles() {
		SecSql sql = new SecSql();
		sql.append("SELECT A.*");
		sql.append("FROM article AS A");
		sql.append("ORDER BY id DESC");
		
		return MysqlUtil.selectRows(sql, Article.class);
	}

	public Article getForPrintArticleById(int id) {
		SecSql sql = new SecSql();
		sql.append("SELECT A.*");
		sql.append("FROM article AS A");
		sql.append("WHERE id = ?", id);
		
		return MysqlUtil.selectRow(sql, Article.class);
	}

	public int delete(int id) {
		SecSql sql = new SecSql();
		sql.append("DELETE FROM article");
		sql.append("WHERE id = ?", id);
		
		return MysqlUtil.delete(sql);
	}

	public int modify(int id, String title, String body) {
		SecSql sql = new SecSql();
		sql.append("UPDATE article");
		sql.append("SET updateDate = Now()");
		
		if( title != null ) {
			sql.append(", title = ?", title);
		}
		
		if( body != null ) {
			sql.append(", body = ?", body);
		}
		
		return MysqlUtil.update(sql);
	}
}
