package org.hibernate.tutorial.hbm;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by coupang on 15. 12. 4..
 */
@Entity
@Table(name = "EVENTS")
public class Event {
	private Long id;
	private String title;
	private Date date;

	public Event(String s, Date date) {
		this.title = s;
		this.date = date;
	}

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	public Long getId() {
		return id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EVENT_DATE")
	public Date getDate() {
		return date;
	}

	public String getTitle() {
		return title;
	}
}
