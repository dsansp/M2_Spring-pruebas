package com.example.M2_Testing_David_Sans.repositories;

import com.example.M2_Testing_David_Sans.entities.SmartPhones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SmartPhonesRepository extends JpaRepository<SmartPhones, Long>{
    List<SmartPhones> findByManufacturerIgnoreCase(String manufacturer);
    List<SmartPhones> findByPriceLessThan(Double price);
    List<SmartPhones> findBymPixelAndRam(Integer mPixels, Integer Ram);
    List<SmartPhones> findByModelIgnoreCase(String model);
}
