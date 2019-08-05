package com.example.tacocloud.repository;

import com.example.tacocloud.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
}
