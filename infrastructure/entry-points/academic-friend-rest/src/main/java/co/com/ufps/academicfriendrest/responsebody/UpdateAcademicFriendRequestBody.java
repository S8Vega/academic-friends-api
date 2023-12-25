package co.com.ufps.academicfriendrest.responsebody;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAcademicFriendRequestBody {
    private String email;
    private int score;
    private String observations;
    private String state;
}
