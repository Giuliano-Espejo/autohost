package com.hostauto.demo.repository;

import com.hostauto.demo.entity.A;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ARepository extends JpaRepository<A,Long> {
}
