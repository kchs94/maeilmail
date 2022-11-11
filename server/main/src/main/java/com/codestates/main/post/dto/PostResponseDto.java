package com.codestates.main.post.dto;

import com.codestates.main.other.member.dto.MemberDTO;
import com.codestates.main.post.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostResponseDto {
    private Long postId;
    private String title;

    private String content;

    private String type;
    private String category;
    private long likeCount;

    private MemberDTO.PostResponse member;

    private LocalDateTime createdAt;

    public PostResponseDto(Post post) {
        this.postId = post.getPostId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.type = post.getType();
        this.category = post.getCategory();
        this.likeCount = post.getLikeCount();
        this.member = new MemberDTO.PostResponse(post.getMember());
        this.createdAt = post.getCreatedAt();
    }
}
