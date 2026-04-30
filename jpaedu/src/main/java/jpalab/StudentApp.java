package jpalab;

import jpalab.controller.StudentController;
import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {
        // TODO : jpalab 패키지에 StudentApp 클래스를 구현하며 수행을 시작하면 다음 메시지를 출력한다.
        Scanner scanner = new Scanner(System.in);
        StudentController controller = new StudentController();

        while (true) {
            System.out.println("처리하려는 기능을 선택하세요.");
            System.out.println("1. 학생 정보 출력");
            System.out.println("2. 학생 정보 입력");
            System.out.println("3. 학생 정보 삭제");
            System.out.println("4. 학생 정보 수정");
            System.out.println("5. 학생 점수 확인");
            System.out.println("6. 종료");
            System.out.print("입력 : ");

            int menu;
            try {
                menu = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
                continue;
            }

            // TODO : 6을 입력하면 프로그램 수행으로 종료한다.
            if (menu == 6) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            String name;
            int score;

            switch (menu) {
                case 1:
                    // TODO : 1을 입력하면 StudentController 의 printAll() 호출
                    controller.printAll();
                    break;
                case 2:
                    // TODO : 2를 입력하면 학생의 이름과 점수를 표준 입력 받아 StudentController의 insert() 호출
                    System.out.print("이름: ");
                    name = scanner.nextLine();
                    System.out.print("점수: ");
                    try {
                        score = Integer.parseInt(scanner.nextLine());
                        controller.insert(name, score);
                    } catch (NumberFormatException e) {
                        System.out.println("점수는 숫자여야 합니다.");
                    }
                    break;
                case 3:
                    // TODO : 3을 입력하면 삭제하려는 학생 이름을 입력받아 StudentController의 delete() 호출
                    System.out.print("삭제할 학생 이름: ");
                    name = scanner.nextLine();
                    controller.delete(name);
                    break;
                case 4:
                    // TODO : 4를 입력하면 수정하려는 학생 이름과 점수를 입력받아 StudentController의 update() 호출
                    System.out.print("수정할 학생 이름: ");
                    name = scanner.nextLine();
                    System.out.print("새 점수: ");
                    try {
                        score = Integer.parseInt(scanner.nextLine());
                        controller.update(name, score);
                    } catch (NumberFormatException e) {
                        System.out.println("점수는 숫자여야 합니다.");
                    }
                    break;
                case 5:
                    // TODO : 5를 입력하면 점수를 확인하고 싶은 학생의 이름을 입력받아 StudentController 의 printScore() 호출
                    System.out.print("점수를 확인할 학생 이름: ");
                    name = scanner.nextLine();
                    controller.printScore(name);
                    break;
                default:
                    System.out.println("잘못된 메뉴 선택입니다.");
                    break;
            }
            // TODO : 6을 제외하고 1번부터 5번의 경우엔 기능을 수행한 다음 다시 메뉴리스트를 출력하여 반복 처리한다.
            System.out.println();
        }
        scanner.close();
    }
}
