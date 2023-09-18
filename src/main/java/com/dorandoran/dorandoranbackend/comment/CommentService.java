package com.dorandoran.dorandoranbackend.comment;

import com.dorandoran.dorandoranbackend.comment.Comment;
import com.dorandoran.dorandoranbackend.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Long saveComment(Comment comment) {
        commentRepository.save(comment);
        return comment.getId();
    }

    public void removeComment(Long id) {
        commentRepository.remove(id);
    }

    public Comment findCommentById(Long id) {
        return commentRepository.findById(id);
    }

    public List<Comment> findCommentsByCommentStatus(Integer status) {
        return commentRepository.findCommentsByStatus(status);
    }

    public List<Comment> findCommentsByCommentUserId(Long userId) {
        return commentRepository.findCommentsByUserId(userId);
    }

    public List<Comment> findAllComments() {
        return commentRepository.findAllComments();
    }
}
