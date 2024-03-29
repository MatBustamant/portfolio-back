package com.matbustamant.beportfolio.models;

import com.matbustamant.beportfolio.enums.BackgroundTypeName;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity(name="BackgroundType")
@Table(name="background_type")
public class BackgroundType implements Serializable{

         @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
         @Column(name="btype_id")
         private Short id;

         @NotNull(message="Nombre no puede ser null.")
         @Column(name="name")
	@Enumerated(EnumType.STRING)
         private BackgroundTypeName name;

         public BackgroundType(BackgroundTypeName name) {
                  this.name = name;
         }

         public BackgroundType() {
         }
}
