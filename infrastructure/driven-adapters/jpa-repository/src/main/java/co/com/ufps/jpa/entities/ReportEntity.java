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
@Table(name = "report")
public class ReportEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "academic_friend")
    private AcademicFriendEntity academicFriend;
    private String type; // (monthly, final)
    private String observations;
    private String state; // (pass, pending, withCorrections, rejected)
    private LocalDateTime date;
    @Column(name = "upload_date")
    private LocalDateTime uploadDate;
}
