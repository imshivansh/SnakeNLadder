package org.example.myFirstProject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private int []board;
    private final Map<Integer,Snake> snakes;

    public int[] getBoard() {
        return board;
    }

    public Map<Integer, Snake> getSnakes() {
        return snakes;
    }

    public Map<Integer, Ladder> getLadders() {
        return ladders;
    }

    private final Map<Integer,Ladder>ladders;

    public Board(int size, int noOfSnakes, int noOfLadders) {
        this.snakes= new HashMap<>();
        this.ladders= new HashMap<>();
        constructBoard(size,noOfSnakes,noOfLadders);
    }

//    private void addPlayers(Queue<Player> players, Queue<Player> playersQueue) {
//        while(!playersQueue.isEmpty()){
//            this.players.add(playersQueue.poll());
//        }
//    }


    private void constructBoard(int size, int noOfSnakes, int noOfLadders) {
        this.board = new int[size*size+1];

        while(noOfSnakes>0){
            int min = 1; // Minimum value (inclusive)
            int max = size*size-2; // Maximum value (inclusive)

            int randomHead = ThreadLocalRandom.current().nextInt(min, max + 1);
            int randomTail=ThreadLocalRandom.current().nextInt(min, max + 1);
            if(randomHead>randomTail && !this.snakes.containsKey(randomHead)){
                this.snakes.put(randomHead,new Snake(randomHead,randomTail));
                noOfSnakes--;

            }

        }
        while(noOfLadders>0){
            int min = 1; // Minimum value (inclusive)
            int max = size*size-2; // Maximum value (inclusive)

            int start = ThreadLocalRandom.current().nextInt(min, max + 1);
            int end=ThreadLocalRandom.current().nextInt(min, max + 1);
            if(start<end && !this.ladders.containsKey(start) && !this.snakes.containsKey(start)){
                this.ladders.put(start,new Ladder(start,end));
                noOfLadders--;

            }

        }


    }
}
