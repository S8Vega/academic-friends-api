package co.com.ufps.jpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity
@Table(name = "course")
public class CourseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String code;
    private String name;
    private int semester;
    private int credits;
}
