/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author olgadakischew
 */


@Entity
@Inheritance
  (strategy = InheritanceType.JOINED)
public class Result implements Serializable {
    private int nr;
    @Id
    private String description;
    private String text;
    @Temporal(TemporalType.DATE)
    private Date createdOn;

	// Getter und Setter
	
	public Result() {
	}

	public Result(int nr, String description, String text) {
		this(nr, description, text, new Date(0));
	}

	public Result(int nr, String description, String text, Date createdOn) {
		this.nr = nr;
		this.description = description;
		this.text = text;
		this.createdOn = createdOn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	
  
}
