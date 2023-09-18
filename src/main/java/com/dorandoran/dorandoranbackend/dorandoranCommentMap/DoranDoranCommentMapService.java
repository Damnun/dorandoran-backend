package com.dorandoran.dorandoranbackend.dorandoranCommentMap;

import com.dorandoran.dorandoranbackend.dorandoranCommentMap.DoranDoranCommentMap;
import com.dorandoran.dorandoranbackend.dorandoranCommentMap.DoranDoranCommentMapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DoranDoranCommentMapService {
    private final DoranDoranCommentMapRepository dorandoranCommentMapRepository;

    public Long saveDoranDoranCommentMap(DoranDoranCommentMap dorandoranCommentMap) {
        dorandoranCommentMapRepository.save(dorandoranCommentMap);
        return dorandoranCommentMap.getId();
    }

    public void removeDoranDoranCommentMap(Long id) {
        dorandoranCommentMapRepository.remove(id);
    }

    public DoranDoranCommentMap findDoranDoranCommentMapById(Long id) {
        return dorandoranCommentMapRepository.findById(id);
    }

    public List<DoranDoranCommentMap> findDoranDoranCommentMapsByDoranDoranId(Long dorandoranId) {
        return dorandoranCommentMapRepository.findDoranDoranCommentMapsByDoranDoranId(dorandoranId);
    }

    public List<DoranDoranCommentMap> findDoranDoranCommentMapsByCommentId(Long commentId) {
        return dorandoranCommentMapRepository.findDoranDoranCommentMapsByCommentId(commentId);
    }

    public List<DoranDoranCommentMap> findAllDoranDoranCommentMaps() {
        return dorandoranCommentMapRepository.findAllDoranDoranCommentMaps();
    }
}