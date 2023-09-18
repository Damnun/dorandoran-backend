package com.dorandoran.dorandoranbackend.dorandoranContentMap;

import com.dorandoran.dorandoranbackend.dorandoranContentMap.DoranDoranContentMap;
import com.dorandoran.dorandoranbackend.dorandoranContentMap.DoranDoranContentMapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DoranDoranContentMapService {
    private final DoranDoranContentMapRepository dorandoranContentMapRepository;

    public Long saveDoranDoranContentMap(DoranDoranContentMap dorandoranContentMap) {
        dorandoranContentMapRepository.save(dorandoranContentMap);
        return dorandoranContentMap.getId();
    }

    public void removeDoranDoranContentMap(Long id) {
        dorandoranContentMapRepository.remove(id);
    }

    public DoranDoranContentMap findDoranDoranContentMapById(Long id) {
        return dorandoranContentMapRepository.findById(id);
    }

    public List<DoranDoranContentMap> findDoranDoranContentMapsByDoranDoranId(Long dorandoranId) {
        return dorandoranContentMapRepository.findDoranDoranContentMapsByDoranDoranId(dorandoranId);
    }

    public List<DoranDoranContentMap> findDoranDoranContentMapsByContentId(Long contentId) {
        return dorandoranContentMapRepository.findDoranDoranContentMapsByContentId(contentId);
    }

    public List<DoranDoranContentMap> findAllDoranDoranContentMaps() {
        return dorandoranContentMapRepository.findAllDoranDoranContentMaps();
    }
}
