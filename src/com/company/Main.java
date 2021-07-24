package com.company;

import com.company.service.Service;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean bool = true;
        do {
            int command;
            System.out.println("Welcome Dear if you want to go far with us please enter Start \n" +
                    "1 - Start \n" +
                    "2 - Exit");
            command = sc.nextInt();
            switch (command) {
                case 1:
                    Service.work();
                    break;
                case 2:
                    bool = false;
                    break;
            }
        } while (bool);
    }
}
