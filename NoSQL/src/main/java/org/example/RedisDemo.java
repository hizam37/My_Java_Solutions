package org.example;

public class RedisDemo {


    public static void main(String[] args) throws InterruptedException {

        RedisStorage redisStorage = new RedisStorage();

        redisStorage.run();
    }
}