package co.com.ufps.jpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String email;
    private String name;
    private String code;
    private String type; // (student, academicFriend, coordinator, director)
}
