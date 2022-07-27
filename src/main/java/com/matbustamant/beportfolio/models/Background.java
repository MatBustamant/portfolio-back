package com.matbustamant.beportfolio.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter @Setter
@Entity(name="Background")
@Table(name="background")
public class Background implements Serializable{

         @Id
         @GeneratedValue(strategy=GenerationType.IDENTITY)
         @Column(name="background_id")
         private Integer id;

         @NotNull(message="Tipo no puede ser null.")
         @ManyToOne(fetch=FetchType.EAGER, optional=false)
         @JoinColumn(name="btype_id")
         private BackgroundType linkedType;

         @NotNull(message="Persona no puede ser null.")
         @ManyToOne(fetch=FetchType.LAZY, optional=false)
         @JoinColumn(name="person_id")
	@JsonBackReference
         private Person linkedPerson;
		 
	@NotNull(message="Institución no puede ser null.")
	@Length(min=5, max=100, message="Institución debe tener entre 5 y 100 caracteres.")
         @Column(name="institution")
         private String institution;
	
	@Column(name="img")
	private String img;

         @NotNull(message="Título no puede ser null.")
         @Length(min=5, max=50, message="Título debe tener entre 5 y 50 caracteres.")
         @Column(name="title")
         private String title;

	@NotNull(message="Fecha de inicio no puede ser null.")
	@Column(name="start_date")
	private LocalDate startDate;
	
	@Column(name="end_date")
	private LocalDate endDate;

         @NotNull(message="Descripción no puede ser null.")
	@Length(max=300, message="Descripción debe tener hasta 300 caracteres.")
         @Column(name="description")
         private String description;

	public Background(BackgroundType linkedType, Person linkedPerson, String institution, String img, String title, LocalDate startDate, LocalDate endDate, String description) {
		this.linkedType = linkedType;
		this.linkedPerson = linkedPerson;
		this.institution = institution;
		this.img = img;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
	}

         public Background() {
         }
}
