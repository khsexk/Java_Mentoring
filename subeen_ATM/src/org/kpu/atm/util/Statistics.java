package org.kpu.atm.util;

import org.kpu.atm.bank.Account;

public class Statistics {
	public static int sum(Account[] account, int size) {
		int sum = 0;
		for (int i = 0; i < size; i++) {
			sum += account[i].getnBalance();
		}
		return sum;
	}

	public static double average(Account[] account, int size) {
		return sum(account, size) / size;
	}

	public static int max(Account[] account, int size) {
		int max = 0;
		for (int i = 0; i < size; i++) {
			if (account[i].getnBalance() > max) {
				max = account[i].getnBalance();
			}
		}
		return max;
	}

	public static Account[] sort(Account[] account, int size) {
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - i - 1; j++) {
				if (account[j].getnBalance() < account[j + 1].getnBalance()) {
					Account temp = account[j];
					account[j] = account[j + 1];
					account[j + 1] = temp;
				}
			}
		}
		return account;
	}
}
