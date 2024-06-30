package org.example;

import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.Random;

public class RedisStorage {

    int usersPerSeconds = 0;

    int generateUserPaid;

    int totalUsersPerSecond = 20;
    private Jedis jedisClient;

    public void run() throws InterruptedException {

        jedisClient = new Jedis();

        jedisClient.zscan("User", "0");

        displayUsers();

        removeKey();
    }


    void displayUsers() throws InterruptedException {
        int userPaid=0;
        while (true) {


            for (int i = 1; i <= 20; i++) {

                usersPerSeconds++;

                generateUserPaid = new Random().nextInt(totalUsersPerSecond) + 1;

                if (i == new Random().nextInt(totalUsersPerSecond) + 1 && (!(userPaid==usersPerSeconds))) {

                    userPaid=generateUserPaid;

                    System.out.println("User " + userPaid + " paid for the service");

                    System.out.println("Displaying user " + userPaid);

                    jedisClient.zadd("User", new Date().getTime(), "User " + userPaid + " paid for the service");

                    jedisClient.zadd("User", new Date().getTime(), "Displaying user " + userPaid);

                    usersPerSeconds--;

                } else if (userPaid == usersPerSeconds) {

                    usersPerSeconds++;

                    System.out.println("Displaying user " + usersPerSeconds);

                    jedisClient.zadd("User", new Date().getTime(), "Displaying user " + usersPerSeconds);

                }

                else {

                    System.out.println("Displaying user " + usersPerSeconds);

                    jedisClient.zadd("User", new Date().getTime(), "Displaying user " + usersPerSeconds);

                }



                if (usersPerSeconds == 20) {

                    usersPerSeconds = 0;

                    Thread.sleep(1000);

                }

            }

        }
    }

    void removeKey() {

        jedisClient.del("User");

    }

}