package com.rainbow.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Department {
    Integer id;
    String name;
    LocalDateTime createTime;
    LocalDateTime updateTime;
}
