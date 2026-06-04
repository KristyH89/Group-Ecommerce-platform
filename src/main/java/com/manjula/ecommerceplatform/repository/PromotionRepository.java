package com.manjula.ecommerceplatform.repository;

import com.manjula.ecommerceplatform.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion,Long> {

//Find promotions that are active on a given date.
    List<Promotion> findAllByCreatAtDate(LocalDate date);

//Optional / AdvancedQueries: Find promotions by code.
    Promotion findAllByCode(String code);

//Optional / AdvancedQueries: Find promotions starting after a given date.
    List<Promotion> findAllByStartDateAfter(LocalDate date);

//Optional / AdvancedQueries: Find promotions ending before a given date.
    List<Promotion> findAllByEndDateBefore(LocalDate date);

//Optional / AdvancedQueries: Find promotions that have no end date.
    Promotion findByEndDateEmpty(LocalDate date);

    //Optional / AdvancedQueries: Find promotions active today.
    Promotion findByStartDateBeforeAndDateAfter(LocalDate date);

}
