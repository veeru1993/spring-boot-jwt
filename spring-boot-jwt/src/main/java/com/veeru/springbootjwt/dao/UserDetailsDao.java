package com.veeru.springbootjwt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.veeru.springbootjwt.model.UserDetails;

@Repository
public interface UserDetailsDao extends JpaRepository<UserDetails, Long>{

	@Query(value = "select ud from UserDetails ud where ud.userName=:userName")
	public List<UserDetails> findAllByUserName(@Param("userName") String userName);
}
