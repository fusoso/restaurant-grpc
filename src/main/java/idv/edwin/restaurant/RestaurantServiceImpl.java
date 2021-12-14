package idv.edwin.restaurant;

import idv.edwin.restaurant.Food;
import idv.edwin.restaurant.FoodRequest;
import idv.edwin.restaurant.FoodResponse;
import idv.edwin.restaurant.RestaurantServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.apache.ibatis.session.SqlSession;

public class RestaurantServiceImpl extends RestaurantServiceGrpc.RestaurantServiceImplBase {

    @Override
    public void listFoods(FoodRequest request, StreamObserver<FoodResponse> responseObserver) {
        try (SqlSession session = MyBatisSqlSessionFactory.buildSqlSessionFactory().openSession()) {
            FoodMapper foodTable = session.getMapper(FoodMapper.class);
            FoodResponse.Builder builder = FoodResponse.newBuilder();
            for (Food food : foodTable.listFoods(request.getCount(), request.getOffset())) {
                builder.addFoods(food);
            }
            FoodResponse foodResponse = builder.build();
            responseObserver.onNext(foodResponse);
            responseObserver.onCompleted();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            responseObserver.onCompleted();
        }

    }
}
