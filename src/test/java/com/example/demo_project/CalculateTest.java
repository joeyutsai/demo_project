package com.example.demo_project;

import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculateTest {
	@Test
	public void calculateTest() {
		int[] numList = { 0, 0 };
		String operator;

		// input
		operator = inputStringJudge();
		numList[0] = inputNumberJudge();
		numList[1] = inputNumberJudge();

		// yes or no
		yesOrNo(operator, numList);

		// calculate
		calculateFunction(operator, numList);

	}
	public String inputString() {
		System.out.println("STEP 1 : Please choose one function: add, minus, multi, division, mod");
		Scanner scan = new Scanner(System.in);
		String chooseFunction = scan.next();
		return chooseFunction;
	}

	public String inputNumber() {
		System.out.println("STEP 2 : Please enter number(Integer) to calculate (number range 2~20)");
		Scanner scan = new Scanner(System.in);
		String number = scan.next();
//		System.out.println(number);
		return number;
	}

	// input and judge the string
	public String inputStringJudge() {
		String[] listFunction = { "add", "minus", "multi", "division", "mod" };
		String checkStr = null;
		int errorCal = 0;

		while (errorCal < 3) {
			checkStr = inputString();
			Boolean checkString = false;
			for (String item : listFunction) {
				if (checkStr.equalsIgnoreCase(item)) {
					checkString = true;
					System.out.println("Correct checkStr: " + checkStr);
				}
			}
			if (checkString) {
				break;
			} else if (errorCal == 2) {
				System.out.println("Error 3 times...STOP the Calculator.");
				checkStr = null;
				break;
			} else {
				System.out.println("Input times: " + (errorCal + 1));
				System.out.println("Enter again...");
				System.out.println();
				errorCal += 1;
			}
		}
		if (checkStr.equals(null)) {
			System.exit(0);
		}
		return checkStr;
	}

	public int inputNumberJudge() {
		int checkNum = 0;
		int errorCal = 0;

		while (errorCal < 3) {
			String num1 = inputNumber();
			float dnum1 = Float.parseFloat(num1);
			int inum1 = Math.round(dnum1);

			if (dnum1 == inum1) {
				if (inum1 >= 2 && inum1 <= 20) {
					checkNum = inum1;
//					System.out.println("Correct: " + inum1);
					break;
				} else {
					System.out.println("Error: Not in the range (2~20) Your number: " + num1);
					System.out.println("Error!! Input times: " + (errorCal + 1));
					errorCal += 1;
				}
			} else if ((dnum1 - inum1) != 0) {
				System.out.println("Error: Not Integer. Your input: " + num1);
				System.out.println("Error!! Input times: " + (errorCal + 1));
				errorCal += 1;
			}
		}
		if (errorCal == 3) {
			System.out.println("Error 3 times...STOP the Calculator.");
			System.exit(0);
		}
		return checkNum;
	}
	
	public void yesOrNo(String operator, int[] numList) {
		System.out.println("STEP 3 : Please check the formula: " + numList[0] + " " + operator + " " + numList[1] + "\nEnter Y or N");
		Scanner scan = new Scanner(System.in);
		String yOrN = scan.next();
		if (yOrN.equalsIgnoreCase("n")) {
			System.out.println("You enter N.  STOP the calculator.");
			System.exit(0);
		}
	}

	public void calculateFunction(String oper, int[] number) {
		switch (oper) {
		case "add":
			addFunction(number);
			break;
		case "minus":
			minusFunction(number);
			break;
		case "multi":
			multiFunction(number);
			break;
		case "division":
			divisionFunction(number);
			break;
		case "mod":
			modFunction(number);
			break;
		}
	}

	public void addFunction(int[] number) {
		int calculate;
		calculate = (number[0] + number[1]);
		System.out.println("addFunction: " + number[0] + " + " + number[1] + " = " + calculate);
	}

	public void minusFunction(int[] number) {
		int calculate;
		calculate = (number[0] - number[1]);
		System.out.println("minusFunction: " + number[0] + " - " + number[1] + " = " + calculate);
	}

	public void multiFunction(int[] number) {
		int calculate;
		calculate = (number[0] * number[1]);
		System.out.println("multiFunction: " + number[0] + " * " + number[1] + " = " + calculate);
	}

	public void divisionFunction(int[] number) {
		int calculate;
		calculate = (number[0] / number[1]);
		System.out.println("divisionFunction: " + number[0] + " / " + number[1] + " = " + calculate);
	}

	public void modFunction(int[] number) {
		int calculate;
		calculate = (number[0] % number[1]);
		System.out.println("modFunction: " + number[0] + " % " + number[1] + " = " + calculate);
	}

}
