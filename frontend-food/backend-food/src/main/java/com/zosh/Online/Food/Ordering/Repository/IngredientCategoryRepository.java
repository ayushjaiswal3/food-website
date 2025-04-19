package com.zosh.Online.Food.Ordering.Repository;

import com.zosh.Online.Food.Ordering.model.IngredientsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientCategoryRepository extends JpaRepository<IngredientsCategory,Long> {

    List<IngredientsCategory> findByRestaurantId(Long id);
}
