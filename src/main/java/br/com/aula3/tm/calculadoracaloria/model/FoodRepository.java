package br.com.aula3.tm.calculadoracaloria.model;

import br.com.aula3.tm.calculadoracaloria.entity.Food;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FoodRepository {

    private static final File FILE = new File("food.json");

    @Autowired
    private ObjectMapper mapper;

    public List<Food> getList(){
        List<Food> anuncios = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<Food>> typeReference = new TypeReference<>() {};
            anuncios = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return anuncios;
    }

    public Food getFoodByName(String name) {
        List<Food> foods = this.getList();

        Optional<Food> foodOptional = foods.stream().filter(food -> food.getName().equals(name)).findAny();

        if(foodOptional.isPresent()) {
            return foodOptional.get();
        }

        return null;
    }

    public List<Food> getFoodByCalories(int calories) {
        List<Food> foodsResponse = new ArrayList<>();
        List<Food> foods = this.getList();

        for (Food food : foods) {
            if(food.getCalories() == calories) {
                foodsResponse.add(food);
            }
        }

        return foodsResponse;
    }

    public void add(Food food) {
        try {
            List<Food> foods = getList();
            foods.add(food);
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(FILE)));
            mapper.writeValue(out, foods);
            out.close();
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
