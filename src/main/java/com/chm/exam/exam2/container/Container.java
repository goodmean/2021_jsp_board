package com.chm.exam.exam2.container;

import com.chm.exam.exam2.http.controller.UsrArticleController;
import com.chm.exam.exam2.http.controller.UsrMemberController;
import com.chm.exam.exam2.repository.ArticleRepository;
import com.chm.exam.exam2.repository.MemberRepository;
import com.chm.exam.exam2.service.ArticleService;
import com.chm.exam.exam2.service.MemberService;

public class Container {
	public static ArticleRepository articleRepository;
	public static ArticleService articleService;
	public static UsrArticleController usrArticleController;

	public static MemberRepository memberRepository;
	public static MemberService memberService;
	public static UsrMemberController usrMemberController;
	
	public static void init() {
		articleRepository = new ArticleRepository();
		articleService = new ArticleService();
		usrArticleController = new UsrArticleController();
		
		memberRepository = new MemberRepository();
		memberService = new MemberService();
		usrMemberController = new UsrMemberController();
	}
}
