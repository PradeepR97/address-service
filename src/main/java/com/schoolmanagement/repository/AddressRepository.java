package com.schoolmanagement.repository;

import com.schoolmanagement.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Address> findByStudentId(Long studentId);
}
