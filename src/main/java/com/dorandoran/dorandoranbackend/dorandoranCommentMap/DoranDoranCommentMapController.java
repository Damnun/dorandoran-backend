package com.dorandoran.dorandoranbackend.dorandoranCommentMap;

import com.dorandoran.dorandoranbackend.comment.Comment;
import com.dorandoran.dorandoranbackend.comment.CommentService;
import com.dorandoran.dorandoranbackend.dorandoranCommentMap.DoranDoranCommentMap;
import com.dorandoran.dorandoranbackend.dorandoranCommentMap.DoranDoranCommentMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dorandoranCommentMap")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DoranDoranCommentMapController {

    private final DoranDoranCommentMapService dorandoranCommentMapService;
    private final CommentService commentService;

    @PostMapping("/create")
    public String create(@RequestParam Long dorandoranId, Long commentId) {
        DoranDoranCommentMap dorandoranCommentMap = new DoranDoranCommentMap();
        dorandoranCommentMap.setDorandoranId(dorandoranId);
        dorandoranCommentMap.setCommentId(commentId);

        Long dorandoranCommentMapId = dorandoranCommentMapService.saveDoranDoranCommentMap(dorandoranCommentMap);
        return dorandoranCommentMapId + "번 도란도란-코멘트 맵 생성 완료";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id) {
        dorandoranCommentMapService.removeDoranDoranCommentMap(id);
        return id + "번 도란도란-코멘트 맵 삭제 완료";
    }

    @GetMapping("/findDoranDoranCommentMapById")
    public DoranDoranCommentMap findDoranDoranCommentMapById(Long id) {
        return dorandoranCommentMapService.findDoranDoranCommentMapById(id);
    }

    @GetMapping("/findDoranDoranCommentMapsByDoranDoranId")
    public List<DoranDoranCommentMap> findDoranDoranCommentMapsByDoranDoranId(Long dorandoranId) {
        return dorandoranCommentMapService.findDoranDoranCommentMapsByDoranDoranId(dorandoranId);
    }

    @GetMapping("/findDoranDoranCommentMapsByCommentId")
    public List<DoranDoranCommentMap> findDoranDoranCommentMapsByCommentId(Long commentId) {
        return dorandoranCommentMapService.findDoranDoranCommentMapsByCommentId(commentId);
    }

    @GetMapping("/findAllDoranDoranCommentMaps")
    public List<DoranDoranCommentMap> findAllDoranDoranCommentMaps() {
        return dorandoranCommentMapService.findAllDoranDoranCommentMaps();
    }

    @GetMapping("/findDoranDoranCommentsByDoranDoranId")
    public List<DoranDoranCommentMapDTO> findDoranDoranCommentsByDoranDoranId(Long doranDoranId, Comment comment) {
        List<DoranDoranCommentMapDTO> result = new ArrayList<>();
        List<DoranDoranCommentMap> commentMapList = dorandoranCommentMapService.findDoranDoranCommentMapsByDoranDoranId(doranDoranId);

        commentMapList.forEach(commentMap -> {
            DoranDoranCommentMapDTO currentDoranDoranCommentMapDTO = new DoranDoranCommentMapDTO();
            currentDoranDoranCommentMapDTO.setComment(commentService.findCommentById(commentMap.getCommentId()));
            currentDoranDoranCommentMapDTO.setDoranDoranId(doranDoranId);
            result.add(currentDoranDoranCommentMapDTO);
        });
        return result;
    }

}
