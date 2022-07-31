package com.matbustamant.beportfolio.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
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
import org.hibernate.validator.constraints.Range;

@Getter @Setter
@Entity(name="Skill")
@Table(name="skill")
public class Skill implements Serializable{

         @Id
         @GeneratedValue(strategy=GenerationType.IDENTITY)
         @Column(name="skill_id")
         private Integer id;

         @NotNull(message="Tipo no puede ser null.")
         @ManyToOne(fetch=FetchType.EAGER, optional=false)
         @JoinColumn(name="stype_id")
         private SkillType linkedType;

         @NotNull(message="Persona no puede ser null.")
         @ManyToOne(fetch=FetchType.LAZY, optional=false)
         @JoinColumn (name="person_id" )
	@JsonBackReference
         private Person linkedPerson;

         @NotNull(message="Nombre no puede ser null.")
         @Length(min=1, max=30, message="Nombre debe tener entre 1 y 30 caracteres.")
         @Column(name="name")
         private String name;

	@NotNull(message="Nivel no puede ser null.")
         @Range(min=0, max=1, message="Nivel debe ser un valor entre 0 y 1.")
         @Column(name="lvl")
         private float lvl;

         public Skill(SkillType linkedType, Person linkedPerson, String name, float lvl) {
                  this.linkedType = linkedType;
		this.linkedPerson = linkedPerson;
                  this.name = name;
		this.lvl = lvl;
         }

         public Skill() {
         }
}
