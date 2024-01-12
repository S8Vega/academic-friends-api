package co.com.ufps.jpa.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "academic_friend")
@PrimaryKeyJoinColumn(name = "email")
public class AcademicFriendEntity extends StudentEntity {

    private String status; // (pass, pending, rejected)
    private String resume;
    private int score;
    private Double average;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "convocation")
    @ToString.Exclude
    private ConvocationEntity convocation;
    private String observations;
    private String contract;
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "academicFriends")
    @ToString.Exclude
    private List<ScheduleEntity> schedules;
    @OneToMany(mappedBy = "academicFriend", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<ReportEntity> reports;
    @OneToMany(mappedBy = "academicFriend", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<ConsultancyEntity> consultancies;
}
