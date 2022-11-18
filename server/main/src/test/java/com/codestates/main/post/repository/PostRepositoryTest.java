package com.codestates.main.post.repository;

import com.codestates.main.post.entity.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest    //
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @DisplayName("게시글 저장 기능 테스트")
    @Test
    void savePostTest() {
        // given
        Post post = Post.builder()
                .title("title")
                .content("content")
                .type("free")
                .category("talk")
                .build();

        // when
        Post findPost = postRepository.save(post);

        // then
        assertThat(findPost.getTitle()).isEqualTo(post.getTitle());
    }

}