package com.kh.hw.member.view;

import java.util.Arrays;
import java.util.Scanner;

import com.kh.hw.member.controller.MemberController;

public class MemberMenu {

	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();

	public MemberMenu() {

	}

	public void mainMenu() {

		while (true) {
			System.out.println("최대 등록 가능한 회원수는 " + mc.SIZE + "명입니다.");
			System.out.println("현재 등록된 회원 수는 " + mc.existMemberNum() + "명입니다.");
			if (mc.existMemberNum() != 10) {
				System.out.println("1. 새 회원 등록");
				System.out.println("2. 회원 검색");
				System.out.println("3. 회원 정보 수정");
				System.out.println("4. 회원 삭제");
				System.out.println("5. 모두 출력");
				System.out.println("9. 끝내기");
				System.out.print("메뉴 번호 : ");
				int num = sc.nextInt();
				switch (num) {
				case 1:
					insertMember();
					break;
				case 2:
					searchMember();
					break;
				case 3:
					updateMember();
					break;
				case 4:
					deleteMember();
					break;
				case 5:
					printAll();
					break;
				case 9:
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
					continue;
				}

			} else if (mc.existMemberNum() == 10) {
				System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
				System.out.println("2. 회원 검색");
				System.out.println("3. 회원 정보 수정");
				System.out.println("4. 회원 삭제");
				System.out.println("5. 모두 출력");
				System.out.println("9. 끝내기");
				System.out.print("메뉴 번호 : ");
				int num = sc.nextInt();
				switch (num) {
				case 1:
					insertMember();
					break;
				case 2:
					searchMember();
					break;
				case 3:
					updateMember();
					break;
				case 4:
					deleteMember();
					break;
				case 5:
					printAll();
					break;
				case 9:
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
					continue;
				}
			}

		}
	}

	public void insertMember() {
		char gender = ' ';
		String id = "";

		System.out.println("새 회원을 등록합니다.");
		System.out.print("아이디 : ");
		while (true) {
			id = sc.next();
			if (mc.checkId(id)) {
				break;
			} else {
				System.out.println("중복된 아이디입니다. 다시 입력해주세요");
				continue;
			}

		}
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("비밀번호 : ");
		String password = sc.next();
		System.out.print("이메일 : ");
		String email = sc.next();
		System.out.print("성별(M/F) : ");
		while (true) {
			gender = sc.next().charAt(0);
			if (gender != 'M' && gender != 'F' && gender != 'f' && gender != 'm') {
				System.out.println("성별을 다시 입력하세요.");
			} else
				break;
		}
		System.out.print("나이 : ");
		int age = sc.nextInt();

		mc.insertMember(id, name, password, email, gender, age);
		return;
	}

	public void searchMember() {

		System.out.println("1. 아이디로 검색하기");
		System.out.println("2. 이름으로 검색하기");
		System.out.println("3. 이메일로 검색하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		int num = sc.nextInt();

		switch (num) {
		case 1:
			searchId();
			break;
		case 2:
			searchName();
			break;
		case 3:
			searchEmail();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			return;
		}

	}

	public void searchId() {

		System.out.print("검색할 아이디 : ");
		String id = sc.next();
		if (mc.searchId(id) == "") {
			System.out.println("검색결과가 없습니다.");
			return;
		} else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			System.out.println(mc.searchId(id));
			return;
		}
	}

	public void searchName() {
		System.out.print("검색할 이름 : ");
		String name = sc.next();
		if (mc.searchName(name)[0] == null) {
			System.out.println("검색결과가 없습니다.");
			return;
		} else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			for(int i = 0; i < mc.searchName(name).length; i++) {
			System.out.println(mc.searchName(name)[i].infrom());
			}
			return;
		}
	}

	public void searchEmail() {
		System.out.print("검색할 이메일 : ");
		String email = sc.next();
		if (mc.searchEmail(email)[0] == null) {
			System.out.println("검색결과가 없습니다.");
			return;
		} else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			for(int i = 0; i <mc.searchEmail(email).length; i++) {
			System.out.println(mc.searchEmail(email)[i].infrom());
			}
			return;
		}
	}

	public void updateMember() {

		System.out.println("1. 비밀번호 수정하기");
		System.out.println("2. 이름 수정하기");
		System.out.println("3. 이메일 수정하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 반호 : ");
		int num = sc.nextInt();

		switch (num) {
		case 1:
			updatePassword();
			break;
		case 2:
			updateName();
			break;
		case 3:
			updateEmail();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			return;
		default:
			System.out.println("잘못 입력하셨습니다.");
			return;
		}

	}

	public void updatePassword() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.next();
		System.out.print("수정할 비밀번호 : ");
		String password = sc.next();
		if (mc.updatePassword(id, password)) {
			System.out.println("수정이 성공적으로 되었습니다.");
			return;
		} else {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		}

	}

	public void updateName() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.next();
		System.out.print("수정할 이름 : ");
		String name = sc.next();
		if (mc.updateName(id, name)) {
			System.out.println("수정이 성공적으로 되었습니다.");
			return;
		} else {
			System.out.println("존재하지 않는 이름입니다.");
			return;
		}
	}

	public void updateEmail() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.next();
		System.out.print("수정할 이메일 : ");
		String email = sc.next();
		if (mc.updateEmail(id, email)) {
			System.out.println("수정이 성공적으로 되었습니다.");
			return;
		} else {
			System.out.println("존재하지 않는 이름입니다.");
			return;
		}

	}

	public void deleteMember() {
		System.out.println("1. 특정 회원 삭제하기");
		System.out.println("2. 모든 회원 삭제하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		int num = sc.nextInt();

		switch (num) {
		case 1:
			deleteOne();
			break;
		case 2:
			deleteAll();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			return;
		default:
			System.out.println("메인으로 돌아갑니다.");
			return;
		}
	}

	public void deleteOne() {
		System.out.print("삭제할 회원의 아이디 : ");
		String id = sc.next();
		System.out.println("정말 삭제하시겠습니까? (y/n) : ");
		char result = sc.next().charAt(0);
		if (result == 'y' || result == 'Y') {
			if (mc.delete(id)) {
				System.out.println("성공적으로 삭제하였습니다.");
				return;
			} else 
				System.out.println("존재하지 않는 아이디입니다.");
			return;
		} else {
			System.out.println("취소하셨습니다.");
			return;
		}
	}

	public void deleteAll() {
		System.out.print("정말 삭제하시겠습니까? (y/n) : ");
		char result = sc.next().charAt(0);
		if (result == 'Y' || result == 'y') {
			mc.delete();
		}
	}

	public void printAll() {
		if (mc.existMemberNum() == 0) {
			System.out.println("저장된 회원이 없습니다.");
		} else if (mc.existMemberNum() != 0) {
			for (int i = 0; i < mc.existMemberNum(); i++) {
				System.out.println(mc.printAll()[i].infrom());
			}
		}

	}

}
