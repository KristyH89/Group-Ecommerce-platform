package com.manjula.ecommerceplatform.repository;


import com.manjula.ecommerceplatform.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    Optional<UserProfile> findByNickname(String nickname);

    List<UserProfile> findByPhoneNumberContaining(String partialPhone);

    List<UserProfile> findByBioIsNotNull();

    List<UserProfile> findByNicknameStartingWith(String prefix);

    long countByPhoneNumberStartingWith(String prefix);
}