package org.example.myFirstProject;

import java.util.Map;
import java.util.Queue;

public class Game {
    Board board;
    Dice dice;
    Queue<Player>players;

    public Game(Board board, Dice dice, Queue<Player> players) {
        this.board = board;
        this.dice = dice;
        this.players = players;
    }

    void startGame(){
        Map<Integer,Snake>snakes = this.board.getSnakes();
        Map<Integer,Ladder>ladders = this.board.getLadders();
        int[]gameBoard = this.board.getBoard();
        int noOfDice = this.dice.getNoOfDice();
        int count=1;

        while(this.players.size()>1){
            Player player = this.players.poll();
            int diceRoll = this.dice.rollDice(noOfDice);
            int position = player.getCurrentPosition()+diceRoll;
            if(position>gameBoard.length){
                System.out.println("Player:"+ player.getName()+" "+"Can not move out of board length, next player turn and dice number is: "+diceRoll);
                this.players.add(player);

            } else if(position==gameBoard.length) {
                player.setCurrentPosition(position-1);
                System.out.println((player.getName()+" Has won the Game and came: "+count+" at position: "+player.getCurrentPosition()));
                if(players.size()==1){
                    System.out.println(players.peek().getName()+" has lost the game");
                }
                count++;
            }else{

                if(snakes.containsKey(position)){
                    player.setCurrentPosition(snakes.get(position).getTail());
                    System.out.println("Player:"+ player.getName()+" "+"got bitten by snake at position: "+position+" and moved down to "+player.getCurrentPosition()+"due to dice thrown number: "+diceRoll);

                } else if (ladders.containsKey(position)){
                    player.setCurrentPosition(ladders.get(position).getEnd());
                    System.out.println("Player:"+ player.getName()+" "+"got ladder at position: "+position+" and climbed to "+player.getCurrentPosition()+"because  dice rolled to number: "+diceRoll);


                }else{
                    System.out.println("Player:"+ player.getName()+" "+"moved to position: "+position+" from "+ player.getCurrentPosition() +"due to rolled dice number: "+diceRoll);
                    player.setCurrentPosition(position);

                }
                this.players.add(player);
            }

        }

    }
}
