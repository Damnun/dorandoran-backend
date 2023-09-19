package com.dorandoran.dorandoranbackend.dorandoran;

import com.dorandoran.dorandoranbackend.dorandoran.DoranDoran;
import com.dorandoran.dorandoranbackend.dorandoran.DoranDoranRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DoranDoranService {

    private final DoranDoranRepository dorandoranRepository;

    public Long saveDoranDoran(DoranDoran dorandoran) {
        dorandoranRepository.save(dorandoran);
        return dorandoran.getId();
    }

    public void removeDoranDoran(Long id) {
        dorandoranRepository.remove(id);
    }

    public DoranDoran findDoranDoranById(Long id) {
        return dorandoranRepository.findById(id);
    }

    public List<DoranDoran> findDoranDoransByDoranDoranTitle(String title) {
        return dorandoranRepository.findDoranDoransByDoranDoranTitle(title);
    }

    public List<DoranDoran> findDoranDoransByuserId(Long userId) {
        return dorandoranRepository.findDoranDoransByUserId(userId);
    }


    public List<DoranDoran> findAllDoranDorans() {
        return dorandoranRepository.findAllDoranDorans();
    }
}
