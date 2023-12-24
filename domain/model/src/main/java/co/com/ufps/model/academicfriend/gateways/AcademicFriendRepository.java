package co.com.ufps.model.academicfriend.gateways;

import co.com.ufps.model.academicfriend.AcademicFriend;

import java.util.List;

public interface AcademicFriendRepository {
    AcademicFriend save(AcademicFriend academicFriend);

    List<AcademicFriend> findAll();
}
