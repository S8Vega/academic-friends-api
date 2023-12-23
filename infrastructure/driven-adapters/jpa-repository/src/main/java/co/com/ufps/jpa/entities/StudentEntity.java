package co.com.ufps.jpa.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "student")
@PrimaryKeyJoinColumn(name = "email")
public class StudentEntity extends UserEntity {

    private int semester;
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<ConsultancyEntity> consultancies;
}
