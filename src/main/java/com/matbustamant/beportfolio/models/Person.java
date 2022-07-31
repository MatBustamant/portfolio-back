package com.matbustamant.beportfolio.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter @Setter
@Entity(name="Person")
@Table(name="person")
public class Person implements Serializable{

         @Id
         @GeneratedValue(strategy=GenerationType.IDENTITY)
         @Column(name="person_id")
         private Integer id;

         @NotNull(message="Nombre no puede ser null.")
         @Length(min=2, max=50, message="Nombre debe tener entre 2 y 50 caracteres.")
         @Column(name="name")
         private String name;

         @NotNull(message="Apellido no puede ser null.")
         @Length(min=2, max=50, message="Apellido debe tener entre 2 y 50 caracteres.")
         @Column(name="surname")
         private String surname;

         @NotNull(message="Ocupación no puede ser null.")
         @Length(min=5, max=50, message="Ocupación debe tener entre 5 y 50 caracteres.")
         @Column(name="occupation")
         private String occupation;
         
	@Length(max=500, message="Descripción debe tener hasta 500 caracteres.")
	@Column(name="about")
         private String about;
         
	@NotNull(message="Imagen no puede ser null.")
	@Column(name="image")
	private String image;
         
         @OneToMany(fetch=FetchType.LAZY, mappedBy="linkedPerson")
	@JsonManagedReference
         private List<Background> backgroundList;

         @OneToMany(fetch=FetchType.LAZY, mappedBy="linkedPerson")
	@JsonManagedReference
         private List<Project> projectList;

         @OneToMany(fetch=FetchType.LAZY, mappedBy="linkedPerson")
	@JsonManagedReference
         private List<Skill> skillList;

         public Person(String name, String surname, String occupation, String about, String image, List<Background> backgroundList, List<Project> projectList, List<Skill> skillList) {
                  this.name = name;
                  this.surname = surname;
                  this.occupation = occupation;
		this.about = about;
		this.image = image;
                  this.backgroundList = backgroundList;
                  this.projectList = projectList;
                  this.skillList = skillList;
         }

         public Person() {
         }
}
