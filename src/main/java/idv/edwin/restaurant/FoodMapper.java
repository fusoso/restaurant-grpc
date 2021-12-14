package idv.edwin.restaurant;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface FoodMapper {
    @Select("SELECT * FROM food LIMIT #{offset}, #{count}")
    @Results(value = {
            @Result(property = "id_", column = "id"),
            @Result(property = "name_", column = "name"),
            @Result(property = "genre_", column = "genre"),
            @Result(property = "price_", column = "price"),
            @Result(property = "cookingMethod_", column = "cooking_method")
    })
    List<Food> listFoods(@Param("count") Integer count, @Param("offset") Integer offset);
}
