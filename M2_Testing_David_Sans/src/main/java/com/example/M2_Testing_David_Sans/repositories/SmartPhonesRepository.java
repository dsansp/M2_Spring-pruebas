package com.example.M2_Testing_David_Sans.repositories;

import com.example.M2_Testing_David_Sans.entities.SmartPhones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SmartPhonesRepository extends JpaRepository<SmartPhones, Long>{


}
