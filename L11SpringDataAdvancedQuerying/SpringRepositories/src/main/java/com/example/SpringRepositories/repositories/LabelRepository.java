package com.example.SpringRepositories.repositories;

import com.example.SpringRepositories.entities.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepository extends JpaRepository<Label,Long> {
}
