package com.codestates.main.post.entity;

import com.codestates.main.auditing.BaseEntity;
import com.codestates.main.comment.entity.Comment;
import com.codestates.main.like.postlike.entity.PostLike;
import com.codestates.main.other.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String category;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @Column
    private long likeCount;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<PostLike> postLikes = new ArrayList<>();

    public void addMember(Member member) {
        this.member = member;
    }

    public void setPostLikes(PostLike postLike) {
        this.postLikes.add(postLike);
    }

    public void addComments(Comment comment) {
        this.comments.add(comment);
        if (comment.getPost() != this){
            comment.addPost(this);
        }
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public void updateCategory(String category) {
        this.category = category;
    }

    /*
    * 좋아요 갯수 업데이트
    * */
    public void updateLikeCount() {
        this.likeCount = (long) postLikes.size();
    }

    public void discountLike(PostLike postLike) {
        this.postLikes.remove(postLike);
    }
}
