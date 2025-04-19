package com.zosh.Online.Food.Ordering.controller;

import com.zosh.Online.Food.Ordering.model.IngredientsCategory;
import com.zosh.Online.Food.Ordering.model.IngredientsItem;
import com.zosh.Online.Food.Ordering.request.IngredientCategoryRequest;
import com.zosh.Online.Food.Ordering.request.IngredientRequest;
import com.zosh.Online.Food.Ordering.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/ingredients")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @PostMapping("/category")
    public ResponseEntity<IngredientsCategory> createIngredientCategory(
            @RequestBody IngredientCategoryRequest req
    ) throws Exception {

        IngredientsCategory item = ingredientService.createIngredientCategory(req.getName(),req.getRestaurantId());

        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PostMapping()
    public ResponseEntity<IngredientsItem> createIngredientItem(
            @RequestBody IngredientRequest req
    ) throws Exception {

        IngredientsItem item = ingredientService.createIngredientItem(req.getRestaurantId(),req.getName(),req.getCategoryId());

        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/stoke")
    public ResponseEntity<IngredientsItem> updateIngredientStock(
            @PathVariable Long id
    ) throws Exception {

        IngredientsItem item = ingredientService.updateStock(id);

        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<List<IngredientsItem>> getRestaurantIngredient(
            @PathVariable Long id
    ) throws Exception {

        List<IngredientsItem> items = ingredientService.findRestaurantsIngredient(id);

        return new ResponseEntity<>(items, HttpStatus.CREATED);
    }

    @GetMapping("/restaurant/{id}/category")
    public ResponseEntity<List<IngredientsCategory>> getRestaurantIngredientCategory(
            @PathVariable Long id
    ) throws Exception {

        List<IngredientsCategory> items = ingredientService.findIngredientCategoryByRestaurantId(id);

        return new ResponseEntity<>(items, HttpStatus.CREATED);
    }
}
