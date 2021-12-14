package idv.edwin.restaurant;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class GrpcServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
            .forPort(5000)
            .addService(new RestaurantServiceImpl()).build();

        server.start();
        server.awaitTermination();
    }
}
