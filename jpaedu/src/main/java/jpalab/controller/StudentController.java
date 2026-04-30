package jpalab.controller;

import jpalab.dao.StudentDAO;
import jpalab.entity.StudentEntity;
import java.util.List;

public class StudentController {
    private StudentDAO dao = new StudentDAO();

    // TODO : void printAll() --> StudentDAO의 getAllStudent()를 호출하고 결과를 화면에 출력한다.
    public void printAll() {
        List<StudentEntity> list = dao.getAllStudent();
        if (list == null || list.isEmpty()) {
            System.out.println("학생 정보가 없습니다.");
        } else {
            for (StudentEntity student : list) {
                System.out.println(student);
            }
        }
    }

    // TODO : void printScore(String name) --> StudentDAO의 getScore()를 호출하고
    // 리턴 결과가 null 이면 "XX 학생은 존재하지 않습니다."를 출력한다.
    // 아니면 "XXX 학생의 점수는 XX 입니다"를 출력한다.
    public void printScore(String name) {
        StudentEntity student = dao.getScore(name);
        if (student == null) {
            System.out.println(name + " 학생은 존재하지 않습니다.");
        } else {
            System.out.println(name + " 학생의 점수는 " + student.getScore() + " 입니다");
        }
    }

    // TODO : void insert(String name, int score) --> StudentDAO의 insertStudent()를 호출한다.
    // 리턴결과가 true 이면 "입력 성공"을 출력한다.
    // 리턴결과가 false 이면 "입력 실패"를 출력한다.
    public void insert(String name, int score) {
        StudentEntity student = new StudentEntity();
        student.setName(name);
        student.setScore(score);
        if (dao.insertStudent(student)) {
            System.out.println("입력 성공");
        } else {
            System.out.println("입력 실패");
        }
    }

    // TODO : void update(String name, int score) --> StudentDAO의 updateStudent()를 호출한다.
    // 리턴결과가 true 이면 "XX 학생의 점수를 변경했습니다."을 출력한다.
    // 리턴결과가 false 이면 "XX 학생은 존재하지 않습니다."를 출력한다.
    public void update(String name, int score) {
        StudentEntity student = new StudentEntity();
        student.setName(name);
        student.setScore(score);
        if (dao.updateStudent(student)) {
            System.out.println(name + " 학생의 점수를 변경했습니다.");
        } else {
            System.out.println(name + " 학생은 존재하지 않습니다.");
        }
    }

    // TODO : void delete(String name) -------------> StudentDAO의 deleteStudent()를 호출한다.
    // 리턴결과가 true 이면 "XX 학생의 데이터를 삭제했습니다."을 출력한다.
    // 리턴결과가 false 이면 "XX 학생은 존재하지 않습니다."를 출력한다.
    public void delete(String name) {
        if (dao.deleteStudent(name)) {
            System.out.println(name + " 학생의 데이터를 삭제했습니다.");
        } else {
            System.out.println(name + " 학생은 존재하지 않습니다.");
        }
    }
}
