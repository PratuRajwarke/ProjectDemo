package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Bug;

@Repository

public interface BugRepository extends JpaRepository<Bug, Long>{

}
