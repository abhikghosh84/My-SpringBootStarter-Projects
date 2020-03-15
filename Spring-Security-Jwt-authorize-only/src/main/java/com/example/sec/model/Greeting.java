package com.example.sec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "greeting")
public class Greeting {
	@Id
	@GeneratedValue
	private Integer greetingId;
	private String greetingName;
	private String greetingMessage;

	public Integer getGreetingId() {
		return greetingId;
	}

	public void setGreetingId(Integer greetingId) {
		this.greetingId = greetingId;
	}

	public String getGreetingName() {
		return greetingName;
	}

	public void setGreetingName(String greetingName) {
		this.greetingName = greetingName;
	}

	public String getGreetingMessage() {
		return greetingMessage;
	}

	public void setGreetingMessage(String greetingMessage) {
		this.greetingMessage = greetingMessage;
	}

	@Override
	public String toString() {
		return "Greeting [greetingId=" + greetingId + ", greetingName=" + greetingName + ", greetingMessage="
				+ greetingMessage + "]";
	}

}
