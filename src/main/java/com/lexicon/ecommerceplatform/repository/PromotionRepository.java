package com.lexicon.ecommerceplatform.repository;

import com.lexicon.ecommerceplatform.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {

    // Find all promotions active on a given date (startDate <= date <= endDate)
    @Query("SELECT p FROM Promotion p WHERE p.startDate <= :date AND p.endDate >= :date")
    List<Promotion> findAllActiveOn(@Param("date") LocalDate date);

    // Find promotions starting after a given date
    List<Promotion> findAllByStartDateAfter(LocalDate date);

    // Find promotions ending before a given date
    List<Promotion> findAllByEndDateBefore(LocalDate date);
}


