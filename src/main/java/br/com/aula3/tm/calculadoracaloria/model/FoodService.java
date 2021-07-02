package br.com.aula3.tm.calculadoracaloria.model;

import br.com.aula3.tm.calculadoracaloria.entity.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    private FoodRepository foodRepository;

    public FoodService() {}

    @Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> findAll() {
        return foodRepository.getList();
    }

    public Food findFoodByName(String name) {
        return foodRepository.getFoodByName(name);
    }

    public List<Food> findFoodByCalories(int calories) {
        return foodRepository.getFoodByCalories(calories);
    }

    public void add(Food food) {
        foodRepository.add(food);
    }
}
