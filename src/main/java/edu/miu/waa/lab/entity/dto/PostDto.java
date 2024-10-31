package edu.miu.waa.lab.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PostDto {
    long id;
    String title;
    String content;
    String author;
}
