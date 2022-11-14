package com.skilldistillery.blackjack.app;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.skilldistillery.players.Player;
import com.skilldistillery.cardgame.*;
import com.skilldistillery.cards.*;
import com.skilldistillery.players.Dealer;

public class BlackJackApp {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		BlackJackApp game = new BlackJackApp();

		game.run(game);

	}

	public void run(BlackJackApp game) {
		Dealer dealer = new Dealer(new BlackjackHand());
		Player player = new Player(new BlackjackHand());

		boolean startPlaying = true;

		while (startPlaying) {
			Deck deck = new Deck();

			deck.shuffle();

			System.out.println("Welcome to BlackJack!");
			System.out.println();

			player.addCard(deck.dealCard());
			player.addCard(deck.dealCard());

			dealer.addCard(deck.dealCard());
			dealer.addCard(deck.dealCard());

			System.out.println("This is Dealer cards: " + dealer.getDealerHand().get(0) + " and hidden card " + "\n"
					+ "Dealer total " + dealer.getDealerHand().get(0).getValue());
			System.out.println("This is Player cards: " + player.getPlayerHand() + "\n" + "Player total "
					+ player.sumOfCardValue());

			game.playerTurn(player, deck, dealer, game);
			game.dealerTurn(dealer, deck);

			if (player.sumOfCardValue() > 21) {

				game.showCards(player, dealer);
				System.out.println("You lost!");
				System.out.println();

			} else if (player.sumOfCardValue() == 21) {

				game.showCards(player, dealer);
				System.out.println("You won!");
				System.out.println();

			} else if (dealer.sumOfCardValue() > 21) {

				game.showCards(player, dealer);
				System.out.println("You won!");
				System.out.println();

			} else if (dealer.sumOfCardValue() == 21) {

				game.showCards(player, dealer);
				System.out.println("You lost!");
				System.out.println();

			} else if (player.sumOfCardValue() > dealer.sumOfCardValue()) {

				game.showCards(player, dealer);
				System.out.println("You won!");
				System.out.println();

			} else if (dealer.sumOfCardValue() > player.sumOfCardValue()) {

				game.showCards(player, dealer);
				System.out.println("You lost!");
				System.out.println();

			} else if (dealer.sumOfCardValue() == player.sumOfCardValue()) {

				game.showCards(player, dealer);
				System.out.println("Push!");
				System.out.println();

			}

			startPlaying = game.startAgain(dealer, player);

		}

	}

	public void playerTurn(Player player, Deck deck, Dealer dealer, BlackJackApp game) {
		boolean exit = false;
		int playerValue = player.sumOfCardValue();

		while (exit == false && playerValue < 21) {
			System.out.println("Would you like to 1.Hit or 2. Stand?");
			System.out.println();

			int answer = 0;
			try {
				answer = sc.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("Enter a valid number");
			}

			switch (answer) {

			case 1:
				player.addCard(deck.dealCard());
				playerValue = player.sumOfCardValue();
				break;

			case 2:

				exit = true;
				break;

			default:

				System.out.println("Input not valid!");
				break;

			}

			game.showCards(player, dealer);
			System.out.println();

		}

	}

	public void dealerTurn(Dealer dealer, Deck deck) {

		int value = dealer.sumOfCardValue();

		while (value < 21) {
			if (value >= 17) {
				break;
			} else if (value < 17) {
				dealer.addCard(deck.dealCard());
			}
			value = dealer.sumOfCardValue();
		}
	}

	public void showCards(Player player, Dealer dealer) {
		System.out.println(
				"This is Dealer cards: " + dealer.getDealerHand() + "\n" + "Dealer total " + dealer.sumOfCardValue());
		System.out.println(
				"This is Player cards: " + player.getPlayerHand() + "\n" + "Player total " + player.sumOfCardValue());
	}

	public boolean startAgain(Dealer dealer, Player player) {
		int answer = 0;

		boolean isPlaying = true;

		System.out.println("Would you like to play again?");
		System.out.println("1. Yes");
		System.out.println("2. No");

		try {
			answer = sc.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("Enter a valid number");
		}

		switch (answer) {

		case 1:

			System.out.println();
			System.out.println("Let's play again!");
			dealer.emptyHand();
			player.emptyHand();
			break;

		case 2:

			System.out.println("Thank you for playng!");
			isPlaying = false;
			break;

		default:

			System.out.println("Input invalid.");

		}

		return isPlaying;
	}
}