package me.dio.model;

import java.util.List;

public class User {

	private Long id;
	private String name;
	private Account account;
	private Card card;
	private List<Features> features;
	private List<News> news;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Card getCard() {
		return card;
	}
	public void setCard(Card card) {
		this.card = card;
	}
	public List<Features> getFeatures() {
		return features;
	}
	public void setFeatures(List<Features> features) {
		this.features = features;
	}
	public List<News> getNews() {
		return news;
	}
	public void setNews(List<News> news) {
		this.news = news;
	}

	
}
