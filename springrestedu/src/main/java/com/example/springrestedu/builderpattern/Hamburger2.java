package com.example.springrestedu.builderpattern;

import lombok.*;

public class Hamburger2 {
    private final int bun;
    private final int patty;
    private final int cheese;
    private final int lettuce;
    private final int tomato;
    private final int bacon;

    // 1. 외부에서 바로 빌더를 시작할 수 있게 해주는 static 메서드
    public static Builder builder() {
        return new Builder();
    }

    // 2. 내부 빌더 클래스
    public static class Builder {
        // 모든 필드를 기본값 0으로 초기화 (유연한 생성을 위해)
        private int bun = 0;
        private int patty = 0;
        private int cheese = 0;
        private int lettuce = 0;
        private int tomato = 0;
        private int bacon = 0;

        // 각 필드 설정 메서드 (메서드 체이닝)
        public Builder bun(int val) { this.bun = val; return this; }
        public Builder patty(int val) { this.patty = val; return this; }
        public Builder cheese(int val) { this.cheese = val; return this; }
        public Builder lettuce(int val) { this.lettuce = val; return this; }
        public Builder tomato(int val) { this.tomato = val; return this; }
        public Builder bacon(int val) { this.bacon = val; return this; }

        // 최종 객체 생성
        public Hamburger2 build() {
            return new Hamburger2(this);
        }
    }

    // 3. private 생성자
    private Hamburger2(Builder builder) {
        this.bun = builder.bun;
        this.patty = builder.patty;
        this.cheese = builder.cheese;
        this.lettuce = builder.lettuce;
        this.tomato = builder.tomato;
        this.bacon = builder.bacon;
    }

    @Override
    public String toString() {
        return String.format("Hamburger [bun=%d, patty=%d, cheese=%d, lettuce=%d, tomato=%d, bacon=%d]",
                bun, patty, cheese, lettuce, tomato, bacon);
    }
}

