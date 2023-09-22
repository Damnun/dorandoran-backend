package com.dorandoran.dorandoranbackend.dorandoranCommentMap;

import com.dorandoran.dorandoranbackend.comment.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DoranDoranCommentMapDTO {
    private Long doranDoranId;
    private Comment comment;
}
