package com.dorandoran.dorandoranbackend.comment;

import com.dorandoran.dorandoranbackend.comment.Comment;
import com.dorandoran.dorandoranbackend.comment.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/create")
    public String create(@RequestParam String text, Integer status, Long userId) {
        Comment comment = new Comment();
        comment.setText(text);
        comment.setStatus(status);
        comment.setUserId(userId);

        Long id = commentService.saveComment(comment);

        return id + "번 댓글 등록 완료";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id) {
        commentService.removeComment(id);
        return id + "번 댓글 삭제 완료";
    }

    @GetMapping("/findCommentByCommentId")
    public Comment findCommentByCommentId(@RequestParam Long id) {
        return commentService.findCommentById(id);
    }

    @GetMapping("/findCommentsByStatus")
    public List<Comment> findCommentsByStatus(@RequestParam Integer status) {
        return commentService.findCommentsByCommentStatus(status);
    }

    @GetMapping("/findCommentsByUserId")
    public List<Comment> findCommentsByCategory(@RequestParam Long userId) {
        return commentService.findCommentsByCommentUserId(userId);
    }
}
