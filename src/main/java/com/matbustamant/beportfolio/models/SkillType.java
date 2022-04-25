package com.matbustamant.beportfolio.models;

import com.matbustamant.beportfolio.enums.SkillTypeName;
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
//import org.hibernate.validator.constraints.Length;

@Getter @Setter
@Entity(name="SkillType")
@Table(name="skill_type")
public class SkillType implements Serializable{

         @Id
         @GeneratedValue(strategy=GenerationType.IDENTITY)
         @Column(name="stype_id")
         private Short id;

         @NotNull(message="Nombre no puede ser null.")
//         @Length(min=4, max=15, message="Nombre debe tener entre 4 y 15 caracteres.")
         @Column(name="name")
	@Enumerated(EnumType.STRING)
         private SkillTypeName name;

         public SkillType(SkillTypeName name) {
                  this.name = name;
         }

         public SkillType() {
         }
}
