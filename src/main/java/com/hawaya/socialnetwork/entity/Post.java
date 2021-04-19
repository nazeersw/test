package com.hawaya.socialnetwork.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;

	@Column(name = "TITLE", nullable = false)
	private String title;

	@Column(name = "CONTENT")
	private String content;

	@Column(name = "POSTED_AT", nullable = false)
	@UpdateTimestamp
	private Date posteDate;

	public Long getID() {
		return id;
	}

	public void setID(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPosteDate() {
		return posteDate;
	}

	public void setPosteDate(Date posteDate) {
		this.posteDate = posteDate;
	}

}
