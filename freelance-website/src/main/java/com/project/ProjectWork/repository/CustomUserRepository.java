package com.project.ProjectWork.repository;

import com.project.ProjectWork.entity.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomUserRepository extends JpaRepository<CustomUser,Long> {
    public CustomUser findByEmail(String email);
    public boolean existsByEmail(String email);

}
