package org.kpu.atm.helpdesk;

import org.kpu.atm.bank.Account;
import java.util.Scanner;

public class CustomerSvc {
	private Account[] acctArray;
	private int nCurrentAcctNum;
	
	private Scanner scan;
	
	public CustomerSvc(Account[] acctArray, int nCurrentAcctNum) {
		this.acctArray = acctArray;
		this.nCurrentAcctNum = nCurrentAcctNum;
	}
	
	public void updatePasswdReq() {
		int id = 0;
		String oldPasswd = "";
		String newPasswd = "";

		scan = new Scanner(System.in);
		System.out.println("계좌번호 입력 : ");
		id = Integer.parseInt(scan.nextLine());
		System.out.println("기존 비밀번호 입력 : ");
		oldPasswd = scan.nextLine();
		System.out.println("신규 비밀번호 입력 : ");
		newPasswd = scan.nextLine();

		for (Account account : this.acctArray) {
			if(account.getID() == id) {
				if (account.updatePasswd(oldPasswd, newPasswd)) {
					System.out.println("비밀번호를 수정했습니다.");
				} else {
					System.out.println("비밀번호 수정에 실패했습니다.");
				}
				break;
			}
		}
		
	}
}
