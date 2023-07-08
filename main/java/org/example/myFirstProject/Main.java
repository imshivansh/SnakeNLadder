package org.example.myFirstProject;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hello and welcome!");
        System.out.println("Let's play snake n ladder");
        System.out.println("Enter the board size");
        int size =  sc.nextInt();
        System.out.println("Enter the number of snakes you want in the board");
        int snakeNumbers = sc.nextInt();
        System.out.println("Enter the number of ladders you want in the board");
        int ladderNumbers = sc.nextInt();
        System.out.println("Enter the number of Dice you wanna play with");
        int numberOfDice = sc.nextInt();
        System.out.println("Enter the number of players in the game");
        int noOfPlayers =sc.nextInt();
        Queue<Player>playersQueue = new LinkedList<>();
        if((snakeNumbers+ladderNumbers)>size*size/2 ||numberOfDice>=size || noOfPlayers==1){
            System.out.println("Not an appropriate condition to play the game");
        }else{
            for(int i =0;i< noOfPlayers;i++){
                int playerNum = i+1;
                System.out.println("Enter the name of the player: "+playerNum);
                String playerName = sc.next();
                playersQueue.add(new Player(playerName));

            }
            sc.close();
            Dice dice =  new Dice(numberOfDice);
            Board gmeBoard = new Board(size,snakeNumbers,ladderNumbers);
            Game game = new Game(gmeBoard,dice,playersQueue);
            game.startGame();


        }








    }
}

/*
Entities

snake
Ladder
Player
Dice
Baord
Game

primary atttribute
snake: int start, int end;
ladder: int start, int end;
player: String name, int id;
dice: int min, int max, int noOf dice
Baord: int size
Game: Board,Player,Dice;

RelationShips
Board: has dice,snake,ladders

so second attribute to the board
Board : int size, dice dice, Map<int start, int end>snakes,Map<int start, int end>ladder;

player:currentPosition,Name,id;


Behaviours:
Player: moveUser
Dice :rolldice
Game:playGame;

 */