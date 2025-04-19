package com.zosh.Online.Food.Ordering.service;

import com.zosh.Online.Food.Ordering.model.IngredientsCategory;
import com.zosh.Online.Food.Ordering.model.IngredientsItem;

import java.util.List;

public interface IngredientService {

    public IngredientsCategory createIngredientCategory(String name, Long restaurantId) throws Exception;

    public IngredientsCategory findIngredientCategoryById(Long id) throws Exception;

    public List<IngredientsCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception;

    public IngredientsItem createIngredientItem(Long restaurantId, String ingredientName, Long categoryId) throws Exception;

    public List<IngredientsItem> findRestaurantsIngredient(Long restaurantId);

    public IngredientsItem updateStock(Long id) throws Exception;
}
