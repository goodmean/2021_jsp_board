package com.chm.exam.exam2.service;

import java.util.List;

import com.chm.exam.exam2.container.Container;
import com.chm.exam.exam2.dto.Article;
import com.chm.exam.exam2.dto.ResultData;
import com.chm.exam.exam2.repository.ArticleRepository;
import com.chm.exam.exam2.util.Ut;

public class ArticleService {
	private ArticleRepository articleRepository = Container.articleRepository;
	
	public ResultData write(String title, String body) {
		int id = articleRepository.write(title, body);
		
		return ResultData.from("S-1", Ut.f("%d번 게시물이 생성되었습니다.", id), "id", id);
	}

	public List<Article> getForPrintArticles() {
		return articleRepository.getForPrintArticles();
	}

}
