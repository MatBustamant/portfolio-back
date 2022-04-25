package com.matbustamant.beportfolio.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter @Setter
@Entity(name="Institution")
@Table(name="institution")
public class Institution implements Serializable{

         @Id
         @GeneratedValue(strategy=GenerationType.IDENTITY)
         @Column(name="institution_id")
         private Integer id;

         @NotNull(message="Nombre no puede ser null.")
         @Length(min=2, max=45, message="Nombre debe tener entre 2 y 45 caracteres.")
         @Column(name="name")
         private String name;

         @Column(name="image")
         private String image;

         @Column(name="website")
         private String website;

         public Institution(String name, String image, String website) {
                  this.name = name;
                  this.image = image;
                  this.website = website;
         }

         public Institution() {
         }
}