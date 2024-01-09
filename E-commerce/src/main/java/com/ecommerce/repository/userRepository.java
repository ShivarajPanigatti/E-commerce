package com.ecommerce.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.User;
@Repository
public interface userRepository extends JpaRepository<User,Integer> {

	User findByeMail(String eMail);

}
