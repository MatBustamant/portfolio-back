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
@Entity(name="Background")
@Table(name="background")
public class Background implements Serializable{

         @Id
         @GeneratedValue(strategy=GenerationType.IDENTITY)
         @Column(name="background_id")
         private Integer id;

         @NotNull(message="Tipo no puede ser null.")
         @ManyToOne(fetch=FetchType.LAZY/*¿?¿? Averiguar bien EAGER*/, optional=false)
         @JoinColumn(name="btype_id")
         private BackgroundType linkedType;

         @NotNull(message="Institución no puede ser null.")
         @ManyToOne(fetch=FetchType.LAZY/*¿?¿? Averiguar bien EAGER*/, optional=false)
         @JoinColumn(name="institution_id")
         private Institution linkedInstitution;

         @NotNull(message="Persona no puede ser null.")
         @ManyToOne(fetch=FetchType.LAZY/*¿?¿? Averiguar bien EAGER*/, optional=false)
         @JoinColumn(name="person_id")
         private Person linkedPerson;

         @NotNull(message="Título no puede ser null.")
         @Length(min=8, max=45, message="Título debe tener entre 8 y 45 caracteres.")
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

         public Background(BackgroundType linkedType, Institution linkedInstitution, Person linkedPerson, String title, Period duration, String description) {
                  this.linkedType = linkedType;
                  this.linkedInstitution = linkedInstitution;
                  this.linkedPerson = linkedPerson;
                  this.title = title;
                  this.duration = duration;
                  this.description = description;
         }

         public Background() {
         }
}