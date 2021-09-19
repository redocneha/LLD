package com.mc;
import  com.mc.service.PlayService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static PlayService playService ;
    public static void main(String[] args) throws IOException {
	            // write your code here
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter no of snakes and enter snake positions in the game");
                int nS = scanner.nextInt();
                HashMap<Integer,Integer> snakes = new HashMap<>();
                for(int i=0;i<nS;i++){
                    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
                    String input[];
                    input = br.readLine().split(" ");
                    snakes.put(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
                }
                HashMap<Integer,Integer> ladders = new HashMap<>();
                System.out.println("Enter no of ladders and enter ladder positions  in the game");
                int nL = scanner.nextInt();
                for(int i=0;i<nL;i++){
                    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
                    String input[];
                    input = br.readLine().split(" ");
                    ladders.put(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
                }
                HashMap<Integer,Player> players = new HashMap<>();
                System.out.println("Enter no of players in the game");
                int nP = scanner.nextInt();
                for(int i=0;i<nP;i++){
                    String name =  scanner.next();
                    players.put(i+1,new Player(name,0));
                }
                playService = PlayService.getInstance(snakes,ladders,players);
                String winner = playService.playGame();
                System.out.println(winner+" wins the game");
        }
}
