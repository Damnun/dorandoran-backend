package com.dorandoran.dorandoranbackend.eventCommentMap;

import com.dorandoran.dorandoranbackend.comment.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EventCommentMapDTO {
    private Long eventId;
    private Comment comment;
}
