package co.com.ufps.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "convocation")
public class ConvocationEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "opening_date")
    private LocalDateTime openingDate;
    @Column(name = "closing_date")
    private LocalDateTime closingDate;
    @Column(name = "evaluation_date")
    private LocalDateTime evaluationDate;
    @Column(name = "results_release_date")
    private LocalDateTime resultsReleaseDate;
    @OneToMany(mappedBy = "convocation", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<AcademicFriendEntity> academicFriends;
}
