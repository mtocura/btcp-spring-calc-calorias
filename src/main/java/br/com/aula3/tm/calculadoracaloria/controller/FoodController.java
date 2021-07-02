package br.com.aula3.tm.calculadoracaloria.controller;

import br.com.aula3.tm.calculadoracaloria.entity.Food;
import br.com.aula3.tm.calculadoracaloria.model.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aula3/tm")
public class FoodController {

    private FoodService foodService;

    public FoodController() {}

    @Autowired
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/foods")
    public ResponseEntity<?> getAllFoods() {
        return ResponseEntity.ok(foodService.findAll());
    }

    @GetMapping("/foods/name/{nome}")
    public ResponseEntity<?> getFoodByName(@PathVariable String nome) {
        Food food = foodService.findFoodByName(nome);

        if(food != null) {
            return ResponseEntity.ok(food);
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/foods/calories/{calories}")
    public ResponseEntity<?> getFoodByName(@PathVariable int calories) {
        List<Food> food = foodService.findFoodByCalories(calories);

        if(food != null) {
            return ResponseEntity.ok(food);
        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/foods")
    public ResponseEntity<?> createFood(@RequestBody Food food) {
        foodService.add(food);
        return ResponseEntity.ok().build();
    }
}
