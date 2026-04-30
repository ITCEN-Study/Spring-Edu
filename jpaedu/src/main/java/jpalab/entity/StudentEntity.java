package jpalab.entity;

import jakarta.persistence.*;

// TODO : jpalab.entity 패키지에 StudentEntity 라는 엔티티 클래스를 생성한다.
// TODO : 이 엔티티 클래스의 매핑되는 DB 테이블은 student 임
@Entity
@Table(name = "student")
public class StudentEntity {
    // TODO : student 라는 DB 테이블은 name 과 score 라는 컬럼을 가지고 있는데 name 이 PK 이다.
    @Id
    private String name;
    private int score;

    // TODO : setter, getter, toString 필수
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentEntity [name=" + name + ", score=" + score + "]";
    }
}
