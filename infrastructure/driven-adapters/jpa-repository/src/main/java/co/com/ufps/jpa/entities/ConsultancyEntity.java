package co.com.ufps.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "consultancy")
public class ConsultancyEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "academic_friend")
    private AcademicFriendEntity academicFriend;
    @ManyToOne
    @JoinColumn(name = "student")
    private StudentEntity student;
    @ManyToOne
    @JoinColumn(name = "course")
    private CourseEntity course;
    @Column(name = "creation_date")
    private LocalDateTime creationDate;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    @Column(name = "difficulties_encountered")
    private String difficultiesEncountered;
    @Column(name = "aspects_to_improve")
    private String aspectsToImprove;
}
