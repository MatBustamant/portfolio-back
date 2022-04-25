package com.matbustamant.beportfolio.models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

@Getter @Setter
@Entity(name="Person")
@Table(name="person")
public class Person implements Serializable{

         @Id
         @GeneratedValue(strategy=GenerationType.IDENTITY)
         @Column(name="person_id")
         private Integer id;

         @NotNull(message="Nombre no puede ser null.")
         @Length(min=2, max=20, message="Nombre debe tener entre 2 y 20 caracteres.")
         @Column(name="name")
         private String name;

         @NotNull(message="Apellido no puede ser null.")
         @Length(min=2, max=20, message="Apellido debe tener entre 2 y 20 caracteres.")
         @Column(name="surname")
         private String surname;

         @NotNull(message="Edad no puede ser null.")
         @Range(min=14, max=65, message="Edad debe ser un valor entre 14 y 65")
         @Column(name="age")
         private byte age;

         @NotNull(message="Ocupación no puede ser null.")
         @Length(min=5, max=25, message="Ocupación debe tener entre 5 y 25 caracteres.")
         @Column(name="occupation")
         private String occupation;
         
         @OneToOne(cascade=CascadeType.ALL)
         @JoinColumn(name="about_id", referencedColumnName="about_id")
         private About about;
         
         @OneToMany(fetch=FetchType.LAZY/*¿?¿? Averiguar bien EAGER*/, mappedBy="linkedPerson")
         private List<Background> backgroundList;

         @OneToMany(fetch=FetchType.LAZY/*¿?¿? Averiguar bien EAGER*/, mappedBy="linkedPerson")
         private List<Project> projectList;

         @OneToMany(fetch=FetchType.LAZY/*¿?¿? Averiguar bien EAGER*/, mappedBy="linkedPerson")
         private List<Skill> skillList;

         public Person(String name, String surname, byte age, String occupation, About about, List<Background> backgroundList, List<Project> projectList, List<Skill> skillList) {
                  this.name = name;
                  this.surname = surname;
                  this.age = age;
                  this.occupation = occupation;
		this.about = about;
                  this.backgroundList = backgroundList;
                  this.projectList = projectList;
                  this.skillList = skillList;
         }

         public Person() {
         }
}
