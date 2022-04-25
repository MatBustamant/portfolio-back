package com.matbustamant.beportfolio.models;

import java.io.Serializable;
import java.time.Period;
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
@Entity(name="Project")
@Table(name="project")
public class Project implements Serializable{

         @Id
         @GeneratedValue(strategy=GenerationType.IDENTITY)
         @Column(name="project_id")
         private Integer id;

         @NotNull(message="Origen no puede ser null.") //quizá sí deba permitir valores nulos, por tanto también debería ser opcional ahí abajo.
         @ManyToOne(fetch=FetchType.LAZY/*¿?¿? Averiguar bien LAZY*/, optional=false)
         @JoinColumn(name="btype_id")
         private BackgroundType linkedBackgroundType; //de donde surge, si por práctica(educación), curso(educación), encargo(trabajo), etc.

         @NotNull(message="Persona no puede ser null.")
         @ManyToOne(fetch=FetchType.LAZY/*¿?¿? Averiguar bien LAZY*/, optional=false)
         @JoinColumn(name="person_id")
         private Person linkedPerson;

         @NotNull(message="Título no puede ser null.")
         @Length(min=8, max=25, message="Título debe tener entre 8 y 25 caracteres.")
         @Column(name="title")
         private String title;

         @NotNull(message="Periodo no puede ser null.")
         @Column(name="duration")
         private Period duration;

         @NotNull(message="Descripción no puede ser null.")
         //@Length(max=200, message="Descripción debe tener menos de 200 caracteres.") ----------
         // SI NO SE USAN DOS DESCRIPCIONES DIFERENTES (UNA CORTA Y OTRA LARGA) ENTONCES ESTA DESCRIPCIÓN
         // NO DEBERÍA TENER UN MÁXIMO DE CARACTERES. AL MENOS NO UNO TAN PEQUEÑO.
         @Column(name="description")
         private String description;

         //@Column(name="full_description") --------------------- ESTO HAY QUE VER CÓMO SE MANEJA LUEGO.
         //private String fullDescription;

         @Column(name="evidence")
         private String evidence; //especificar más esto. Link a repositorio? Capturas? Link al deploy? Quizá dar opciones. Cómo?

         public Project(BackgroundType linkedBackgroundType, Person linkedPerson, String title, Period duration, String description, String evidence) {
                  this.linkedBackgroundType = linkedBackgroundType;
                  this.linkedPerson = linkedPerson;
                  this.title = title;
                  this.duration = duration;
                  this.description = description;
                  this.evidence = evidence;
         }

         public Project() {
         }
}
