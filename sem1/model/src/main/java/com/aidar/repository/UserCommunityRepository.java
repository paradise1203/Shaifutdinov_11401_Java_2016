package com.aidar.repository;

import com.aidar.model.Community;
import com.aidar.model.User;
import com.aidar.model.UserCommunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by paradise on 16.04.16.
 */
@Repository
public interface UserCommunityRepository extends JpaRepository<UserCommunity, Long> {

    UserCommunity findOneByUserAndCommunity(User user, Community community);

}
