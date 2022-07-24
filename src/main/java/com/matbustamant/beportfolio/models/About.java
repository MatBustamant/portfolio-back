package com.matbustamant.beportfolio.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name="About")
@Table(name="about")
public class About implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="about_id")
	private Integer id;
	
	@NotNull(message="Descripción no puede ser null.")
         @Column(name="description")
         private String description;
	
	@OneToOne(mappedBy = "about")
	@JsonBackReference
	private Person linkedPerson;
	
         public About(String description) {
		this.description = description;
	}

	public About() {
	}
}
