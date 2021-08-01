package org.kpu.atm.bank;

public class Account {
	private int nID;				//계좌 번호 
	private int nBalance;			//계좌 잔고 
	private String strAccountName;	//고객 명 
	private String strPassword;		//계좌 비밀번호 
	
	public Account(int id, int money, String name, String password) {
		this.nID = id;
		this.nBalance = money;
		this.strAccountName = name;
		this.strPassword = password;
	}
	
	boolean authenticate(int id, String passwd) {//계정 확인
		return ((this.nID == id) && (this.strPassword.equals(passwd)));
	}
	
	public int getID() {
		return nID;
	}
	
	public int getnBalance() {
		return nBalance;
	}
	
	//추가기능1 계좌 입금 
	int deposit(int money) {		//입금
		this.nBalance += money;
		return this.nBalance;
	}
	
	//추가기능2 계좌 출금 
	public int widraw(int money) {	//출금 
		this.nBalance -= money;
		return this.nBalance;
	}
	
	//추가기능4 고객 센터 (비밀번호 변경)
	public boolean updatePasswd(String oldPasswd, String newPasswd) {
		if(oldPasswd.equals(newPasswd) || !(this.strPassword.equals(oldPasswd))) {
			return false;
		}
		this.strPassword = newPasswd;
		return true;
	}
	
	//추가기능5 고객 관리 
	public String getAccountName() { // 고객 명 읽기 
		return this.strAccountName;
	}

}
