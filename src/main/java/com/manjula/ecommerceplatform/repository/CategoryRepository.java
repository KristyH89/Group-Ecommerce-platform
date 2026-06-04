package com.manjula.ecommerceplatform.repository;

import com.manjula.ecommerceplatform.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {


    //Find a category by name (case-insensitive).
    Category findByNameContainingIgnoreCase(String name);


//Check if a category exists by name.
    Category checkIfNameExists(String name);

//Optional / Advanced Queries:Find categories whose name contains a given keyword.
    List<Category> findAllByNameContainingKeywordAsc(String keyword);
// Optional/ Advanced Queries: Count how many categories exist.
    List<Category> countCategoriesByNameExistsAndId(String name, Long id);

}
