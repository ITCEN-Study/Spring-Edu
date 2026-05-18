package com.example.springrestedu.builderpattern;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
class Hamburger3 {
    private int bun;
    private int patty;
    private int cheese;
    private int lettuce;
    private int tomato;
    private int bacon;
}

