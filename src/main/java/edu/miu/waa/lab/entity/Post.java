package edu.miu.waa.lab.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Post {
    long id;
    String title;
    String content;
    String author;
}
