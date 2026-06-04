package com.lexicon.ecommerceplatform.repository;

import com.lexicon.ecommerceplatform.entity.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PromotionRepository extends JpaRepository<Promotion,Long> {

    /*
//Find promotions that are active on a given date.
    List<Promotion> findAllByCreatAtDate(LocalDate date);
    *** this code has en spellings error.



//Optional / AdvancedQueries: Find promotions by code.
    Promotion findAllByCode(String code);
 *** this has to be findByCode not findAllByCode.

     */
//Optional / AdvancedQueries: Find promotions starting after a given date.
    List<Promotion> findAllByStartDateAfter(LocalDate date);

//Optional / AdvancedQueries: Find promotions ending before a given date.
    List<Promotion> findAllByEndDateBefore(LocalDate date);

    /*
//Optional / AdvancedQueries: Find promotions that have no end date.
    Promotion findByEndDateEmpty(LocalDate date);

    *** this code is not working.


    //Optional / AdvancedQueries: Find promotions active today.
   *** this is giving an error, I will hide it for now.
   Promotion findByStartDateBeforeAndDateAfter(LocalDate date);


     */

}

