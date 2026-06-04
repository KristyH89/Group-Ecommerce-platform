package com.lexicon.ecommerceplatform.repository;

import com.lexicon.ecommerceplatform.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {


    //Find a category by name (case-insensitive).
    Category findByNameContainingIgnoreCase(String name);

/*
//Check if a category exists by name.
    Category checkIfNameExists(String name);
    This one does not work. Error: Spring Data JPA only supports the pattern "existsBy<Property>()"
    That is why I changed it to a boolean:
 */
    boolean existsByNameIgnoreCase(String name);

    /*
    Both of them are giving errors. I hide it for now so I can test if the app is running.

//Optional / Advanced Queries:Find categories whose name contains a given keyword.
    List<Category> findAllByNameContainingKeywordAsc(String keyword);
// Optional/ Advanced Queries: Count how many categories exist.
    List<Category> countCategoriesByNameExistsAndId(String name, Long id);
*/

}
