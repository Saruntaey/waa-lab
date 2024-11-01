package edu.miu.waa.lab.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PostDto {
    private long id;
    private String title;
    private String content;
    private String author;
}
