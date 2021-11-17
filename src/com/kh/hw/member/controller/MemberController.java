package com.kh.hw.member.controller;

import java.util.Arrays;

import com.kh.hw.member.model.vo.Member;

public class MemberController {

	private Member[] m = new Member[SIZE];
	public static final int SIZE = 10;

	public int existMemberNum() {
		int count = 0;

		for (int i = 0; i < m.length; i++) {
			if (m[i] != null) {
				count++;
			}
		}
		return count;
	}

	public boolean checkId(String inputId) {
		boolean bl = true;

		for (int i = 0; i < existMemberNum(); i++) {

			if (m[i].getId().equals(inputId)) {
				bl = !bl;
				break;
			}
		}
		return bl;
	}

	public void insertMember(String id, String name, String password, String email, char gender, int age) {
		for (int i = 0; i < m.length; i++) {
			if (m[i] == null) {
				m[i] = new Member(id, name, password, email, gender, age);
				break;
			}
		}
	}

	public String searchId(String id) {
		String result = "";
		for (int i = 0; i < existMemberNum(); i++) {
			if (m[i].getId().equals(id)) {
				result = m[i].infrom();
			}
		}
		
		return result;
	}

	public Member[] searchName(String name) {
		Member[] result = new Member[existMemberNum()];
		int count = 0;
		for (int i = 0; i < existMemberNum(); i++) {
			if (m[i].getName().equals(name)) {
				result[count] = m[i];
				count++;
			}
		}
		return result;
	}

	public Member[] searchEmail(String email) {
		Member[] result = new Member[existMemberNum()];
		int count = 0;
		for (int i = 0; i < existMemberNum(); i++) {
			if (m[i].getEmail().equals(email)) {
				result[count] = m[i];
				count++;
			}
		}
		return result;
	}

	public boolean updatePassword(String id, String password) {
		boolean bl = false;
		for (int i = 0; i < existMemberNum(); i++) {
			if (m[i].getId().equals(id)) {
				m[i].setPassword(password);
				bl = !bl;
			}
		}
		System.out.println(bl);
		return bl;
	}



	public boolean updateName(String id, String name) {
		boolean bl = false;
		for (int i = 0; i < existMemberNum(); i++) {
			if (m[i].getId().equals(id)) {
				m[i].setName(name);
				bl = !bl;
			}
		}

		return bl;
	}

	public boolean updateEmail(String id, String email) {
		boolean bl = false;
		for (int i = 0; i < existMemberNum(); i++) {
			if (m[i].getId().equals(id)) {
				m[i].setEmail(email);
				bl = !bl;
			}
		}

		return bl;
	}

	public boolean delete(String id) {
		boolean bl = false;
		for (int i = 0; i < existMemberNum(); i++) {
			if (m[i].getId().equals(id)) {
				m[i] = null;
				bl = !bl;
			}
		}

		return bl;
		
	}

	public void delete() {
		for(int i = 0; i < m.length; i++) {
			m[i] = null;
		}

	}

	public Member[] printAll() {

		return m;
	}
}
