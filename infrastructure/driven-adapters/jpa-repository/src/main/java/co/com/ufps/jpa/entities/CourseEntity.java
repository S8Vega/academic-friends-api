package co.com.ufps.jpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

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
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<ConsultancyEntity> consultancies;
}
