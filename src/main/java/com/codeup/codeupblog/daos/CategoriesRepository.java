package com.codeup.codeupblog.daos;

import com.codeup.codeupblog.models.Categories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesRepository extends CrudRepository<Categories, Long> {

}
