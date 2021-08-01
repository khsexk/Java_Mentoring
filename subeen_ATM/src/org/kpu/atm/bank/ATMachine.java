package org.kpu.atm.bank;

import java.util.Scanner;
import org.kpu.atm.helpdesk.CustomerSvc;
import org.kpu.atm.util.Statistics;

public class ATMachine {
	private Account[] accountArray; // 고객계좌배열 참조변수
	private int nMachineBalance; // ATM잔고
	private int nMaxAccountNum; // 고객계좌 참조변수 배열크기
	private int nCurrentAccountNum; // 개설된 고객계좌 수
	private String strManagerPassword; // 관리자 비밀번호

	public static final int BASE_ACCOUNT_ID = 100;
	private Scanner scan;

	public ATMachine(int size, int balance, String password) {
		this.nMachineBalance = balance;
		this.nMaxAccountNum = size;
		this.nCurrentAccountNum = 0;
		this.strManagerPassword = password;
		this.accountArray = new Account[this.nMaxAccountNum];
	}

	public void createAccount() { // 1.계좌 개설
		String menu = "----------개설----------";
		System.out.println(menu);

		scan = new Scanner(System.in);
		System.out.print("이름 입력:");
		String name = scan.nextLine();
		System.out.print("암호 입력:");
		String password = scan.nextLine();

		int countID = BASE_ACCOUNT_ID + nCurrentAccountNum;

		Account account = new Account(countID, 0, name, password);
		accountArray[nCurrentAccountNum] = account;
		nCurrentAccountNum++;

		System.out.println(name + "님 " + countID + "번 계좌번호가 정상적으로 개설되었읍니다. 감사합니다.");
	}

	public void checkMoney() { // 2.계좌 조회
		int id = 0;
		String password = "";

		String menu = "----------조회----------";
		System.out.println(menu);

		scan = new Scanner(System.in);
		System.out.print("계좌번호 입력 : ");
		id = Integer.parseInt(scan.nextLine()); // nextInt를 선언하고 밑에 nextLine을 선언하면, nextLine때 문자를 못 받으므로 이렇게 처
		System.out.print("비밀번호 입력 : ");
		password = scan.nextLine();

		for (Account account : accountArray) {
			if (account.authenticate(id, password)) {
				System.out.println("계좌 잔액 : " + account.getnBalance());
				break;
			}
		}
		// 여기서 잘못 입력하면 어떻게 해야 하지...
	}

	public void displayMenu() { // 메인 메뉴 표시
		String menu = "-------------------------\n" + "-\tKPU bank\t-\n" + "-------------------------";
		System.out.println(menu);
	}

	// 추가기능1 계좌 입금
	public void depositMoney() { // 3.계좌 입금
		int id = 0;
		String password = "";
		int money = 0;

		String menu = "----------입금----------";
		System.out.println(menu);

		scan = new Scanner(System.in);
		System.out.print("계좌번호 입력 : ");
		id = Integer.parseInt(scan.nextLine()); // nextInt를 선언하고 밑에 nextLine을 선언하면, nextLine때 문자를 못 받으므로 이렇게 처
		System.out.print("비밀번호 입력 : ");
		password = scan.nextLine();
		System.out.print("입금 액 입력 : ");
		money = Integer.parseInt(scan.nextLine());

		for (Account account : accountArray) {
			if (account.authenticate(id, password)) {
				account.deposit(money);
				
				nMachineBalance += money;
				System.out.println("입금 후 잔액 : " + money);
				break;
			}
		}
	}

	// 추가기능2 계좌 출금
	public void widrawMoney() { // 4.계좌 출금
		int id = 0;
		String password = "";
		int money = 0;

		String menu = "----------출금----------";
		System.out.println(menu);

		scan = new Scanner(System.in);
		System.out.print("계좌번호 입력 : ");
		id = Integer.parseInt(scan.nextLine()); // nextInt를 선언하고 밑에 nextLine을 선언하면, nextLine때 문자를 못 받으므로 이렇게 처
		System.out.print("비밀번호 입력 : ");
		password = scan.nextLine();

		for (Account account : accountArray) {
			if (account.authenticate(id, password)) {
				while (true) {
					System.out.println("출금 액 입력 : ");
					money = Integer.parseInt(scan.nextLine());
					if (money <= account.getnBalance() && nMachineBalance >= money) {
						account.widraw(money);
						nMachineBalance -= money;
						System.out.println("출금 후 잔액 : " + account.getnBalance());
						break;
					} else {
						System.out.println("잔액이 부족합니다.");
					}
				}
			}
			break;
		}
	}

	// 추가기능3 계좌 이체
	public void transfer() { // 5. 계좌 이체
		int id = 0;
		int transfer_id = 0;
		String password = "";
		int money = 0;

		String menu = "----------이체----------";
		System.out.println(menu);

		scan = new Scanner(System.in);
		System.out.print("계좌번호 입력 : ");
		id = Integer.parseInt(scan.nextLine());
		System.out.print("비밀번호 입력 : ");
		password = scan.nextLine();
		System.out.print("이체계좌 입력 : ");
		transfer_id = Integer.parseInt(scan.nextLine());

		for (Account account : accountArray) {
			if (account.authenticate(id, password)) {
				for (Account transfer_account : accountArray) {
					if (transfer_account.getID() == transfer_id) {
						while (true) {
							System.out.print("이체금액 입력 : ");
							money = Integer.parseInt(scan.nextLine());
							if (money <= account.getnBalance()) {
								account.widraw(money); // 출금
								transfer_account.deposit(money); // 입금
								break;
							} else {
								System.out.println("잔액이 부족합니다.");
							}
						}
						System.out.println(
								"이체 계좌를 다시 확인하세요.\n" + "현재 잔액 : " + account.getnBalance() + "\n계좌 이체를 완료하였습니다.");
						break;
					}
				}
				break;
			}
			break;
		}
	}

	// 추가 기능 4 고객센터(비밀번호 변경)
	public void requestSvc() {
		String menu = "---------암호변경---------";
		System.out.println(menu);

		CustomerSvc cSvc = new CustomerSvc(accountArray,nCurrentAccountNum);
		cSvc.updatePasswdReq();
	}

	// 추가기능 5 고객관리
	public void managerMode() {
		String adminPasswd = "";
		scan = new Scanner(System.in);
		
		String menu = "---------고객관리---------";
		System.out.println(menu);
		
		System.out.print("관리자 비밀번호 입력 : ");
		adminPasswd = scan.nextLine();
		if(adminPasswd.equals(strManagerPassword)) {
			System.out.println("ATM 현금 잔고 :\t" + this.nMachineBalance + "\n"
								+"고객 잔고 총액:\t" + Statistics.sum(accountArray,nCurrentAccountNum) + "원" + "(" + this.nCurrentAccountNum + "명)\n"
								+"고객 잔고 평균:\t" + (int)Statistics.average(accountArray,nCurrentAccountNum) + "원\n" 
								+"고객 잔고 최고:\t" + Statistics.max(accountArray, nCurrentAccountNum) + "원\n");
			System.out.println("고객 계좌 현황(고객 잔고 내림 차순 정렬)");
			Statistics.sort(accountArray,nCurrentAccountNum);
			for(int i = 0; i < nCurrentAccountNum; i++) {
				System.out.println(accountArray[i].getAccountName() + "\t" + accountArray[i].getID() + "\t" + accountArray[i].getnBalance()+ "원");
			}
		}
	}
}
