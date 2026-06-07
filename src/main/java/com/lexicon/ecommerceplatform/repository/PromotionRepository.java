package com.lexicon.ecommerceplatform.repository;

import com.lexicon.ecommerceplatform.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion,Long> {

//Find promotions that are active on a given date.
// Find promotions that are active on a given date.
@Query("""
        SELECT p
        FROM Promotion p
        WHERE :date BETWEEN p.startDate AND p.endDate
    """)
List<Promotion> findActivePromotions(@Param("date") LocalDate date);

//Optional / AdvancedQueries: Find promotions by code.
    Promotion findAllByCode(String code);

//Optional / AdvancedQueries: Find promotions starting after a given date.
    List<Promotion> findAllByStartDateAfter(LocalDate date);

//Optional / AdvancedQueries: Find promotions ending before a given date.
    List<Promotion> findAllByEndDateBefore(LocalDate date);

//Optional / AdvancedQueries: Find promotions that have no end date.
    Promotion findByEndDateEmpty(LocalDate date);

    //Optional / AdvancedQueries: Find promotions active today.
    // Find promotions active today.
    @Query("""
        SELECT p
        FROM Promotion p
        WHERE CURRENT_DATE BETWEEN p.startDate AND p.endDate
    """)
    List<Promotion> findActiveToday();

}
