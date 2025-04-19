package com.zosh.Online.Food.Ordering.service;

import com.zosh.Online.Food.Ordering.model.Category;

import java.util.List;

public interface CategoryService {

    public Category createCategory(String num, Long userId) throws Exception;

    public List<Category> findCategoryByRestaurant(Long id) throws Exception;

    public Category findCategoryById(Long id) throws Exception;
}
