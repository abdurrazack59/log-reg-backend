package com.proacscent.demo.repositories;

import com.proacscent.demo.entities.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser,Long> {

    ApplicationUser findByEmail(String email);
}
