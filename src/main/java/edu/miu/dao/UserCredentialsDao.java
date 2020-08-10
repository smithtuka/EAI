package edu.miu.dao;

import edu.miu.domain.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialsDao extends JpaRepository<UserCredentials, Long> {
}
