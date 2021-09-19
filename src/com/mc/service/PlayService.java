package com.mc.service;
import com.mc.Player;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.HashMap;

public class PlayService {
    private static PlayService playService;
    private static int[] board ;
    private static HashMap<Integer,Integer> snakes;
    private static HashMap<Integer,Integer> ladders;
    private static HashMap<Integer,Player> players;

    public static PlayService getInstance(HashMap<Integer,Integer> snakes,HashMap<Integer,Integer> ladders,HashMap<Integer, Player> players){
        if(playService==null)
        {
            playService = new PlayService(snakes, ladders, players);
            board = new int[100];
            initialize(snakes,ladders,board);
        }
        return playService;
    }

    private static void initialize(HashMap<Integer, Integer> snakes, HashMap<Integer, Integer> ladders, int[] board) {
        Arrays.fill(board,0);
        for(Map.Entry<Integer,Integer> e:snakes.entrySet()){
            board[e.getKey()-1] = -1;
        }
        for(Map.Entry<Integer,Integer> e:ladders.entrySet()){
            board[e.getKey()-1] = 1;
        }
    }

    public PlayService(HashMap<Integer,Integer> snakes,HashMap<Integer,Integer> ladders,HashMap<Integer,Player> players){
        this.snakes = snakes;
        this.ladders = ladders;
        this.players = players;
    }
    public static String playGame(){
        int curr = 0;
        int diceValue=0;
        int currPos=0;
        int nP=players.size(),nS=snakes.size(),nL=ladders.size();
        while(true){
            curr = (curr%nP)+1;
            diceValue = rollDice()+1;
            int prevPos = players.get(curr).getPos();
            currPos = prevPos+diceValue;
            Player p = players.get(curr);
            if(board[currPos-1]==-1) p.setPos(snakes.get(currPos));
            else if(board[currPos-1]==1) p.setPos(ladders.get(currPos));
            else p.setPos(currPos);
            players.put(curr,p);
            System.out.println(p.getName()+" rolled a "+diceValue+" and moved from "+prevPos+" to "+players.get(curr).getPos());
            if(currPos==100) break;
            //curr=curr+1;
        }
        return players.get(curr).getName();
    }

    private static int rollDice() {
        Random r = new Random();
        return r.nextInt(5);
    }

}
