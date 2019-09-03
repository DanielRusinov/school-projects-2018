package org.elsys.cardgame;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.CardException;
import org.elsys.cardgame.api.Rank;
import org.elsys.cardgame.api.Suit;
import org.elsys.cardgame.factory.CardImpl;
import org.elsys.cardgame.factory.GameImpl;
import org.elsys.cardgame.operations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.elsys.cardgame.factory.GameFactory.*;

public class Main {

	private static List<Card> deck = new ArrayList<Card>();

	public static void main(String[] args) {
		GameImpl game = new GameImpl();

		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();

		String[] cards = line.split(" ");

		for(int i = 0; i < cards.length; i++){
			String suit = cards[i].substring(0,1);
			String rank = cards[i].substring(1);
			CardImpl card = new CardImpl(Suit.convert(suit), Rank.convert(rank));
			deck.add(card);
		}

		line = scan.nextLine();
		
		try {
			if(line.equals("Santase")){
				game = (GameImpl) createSantaseGame(deck);
			} else if(line.equals("Belote")){
				game = (GameImpl) createBeloteGame(deck);
			} else if(line.equals("War")){
				game = (GameImpl) createWarGame(deck);
			}
		} catch (CardException e) {
			System.out.println(e.getMessage());
		}


		
		while(scan.hasNext()){
			String operation = scan.nextLine();

			if (operation.equals("quit")){
				break;
			}
			try {
				game.process(operation);
			} catch (CardException e) {
				System.out.println(e.getMessage());
			}
		}


	}

}
