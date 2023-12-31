package co.com.ufps.academicfriendrest.responsebody;

import co.com.ufps.model.academicfriend.AcademicFriend;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AcademicFriendResponseBody {
    private String email;
    private String name;
    private String code;
    private String type;

    private String semester;

    private String status; // (pass, pending, rejected)
    private String resume;
    private int score;
    private Double average;
    private String observations;
    private String contract;

    public static AcademicFriendResponseBody from(AcademicFriend academicFriend) {
        return AcademicFriendResponseBody.builder()
                .email(academicFriend.getEmail())
                .name(academicFriend.getName())
                .code(academicFriend.getCode())
                .type(academicFriend.getType())
                .semester(academicFriend.getSemester())
                .status(academicFriend.getStatus())
                .resume(academicFriend.getResume())
                .score(academicFriend.getScore())
                .average(academicFriend.getAverage())
                .observations(academicFriend.getObservations())
                .contract(academicFriend.getContract())
                .build();
    }

    public static List<AcademicFriendResponseBody> from(List<AcademicFriend> academicFriends) {
        return academicFriends.stream().map(AcademicFriendResponseBody::from).toList();
    }
}
