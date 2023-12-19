package co.com.ufps.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
@Table(name = "academic_friend")
@PrimaryKeyJoinColumn(name = "email")
public class AcademicFriendEntity extends StudentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String status; // (pass, pending, rejected)
    private String resume;
    private int score;
    private Double average;
    @ManyToOne
    @JoinColumn(name = "convocation")
    private ConvocationEntity convocation;
    private String observations;
    @Column(name = "class_schedule")
    private String classSchedule;
    @OneToMany(mappedBy = "academicFriend", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<ScheduleEntity> schedules;
    @OneToMany(mappedBy = "academicFriend", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<ReportEntity> reports;
    @OneToMany(mappedBy = "academicFriend", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<ConsultancyEntity> consultancies;
}
