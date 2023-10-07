package com.dorandoran.dorandoranbackend.dorandoran;

import com.dorandoran.dorandoranbackend.dorandoran.DoranDoran;
import com.dorandoran.dorandoranbackend.dorandoran.DoranDoranService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dorandoran")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DoranDoranController {

    private final DoranDoranService dorandoranService;

    @PostMapping("/create")
    public String create(@RequestParam String title, String description, Long userId) {
        DoranDoran dorandoran = new DoranDoran();
        dorandoran.setTitle(title);
        dorandoran.setDescription(description);
        dorandoran.setUserId(userId);

        Long id = dorandoranService.saveDoranDoran(dorandoran);

        return id + "번 도란도란 등록 완료";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam Long id) {
        dorandoranService.removeDoranDoran(id);
        return id + "번 도란도란 삭제 완료";
    }

    @GetMapping("/findDoranDoranByDoranDoranId")
    public DoranDoran findDoranDoranByDoranDoranId(@RequestParam Long id) {
        return dorandoranService.findDoranDoranById(id);
    }

    @GetMapping("/findDoranDoransByTitle")
    public List<DoranDoran> findDoranDoransByTitle(@RequestParam String title) {
        return dorandoranService.findDoranDoransByDoranDoranTitle(title);
    }

    @GetMapping("/findDoranDoransByUserId")
    public List<DoranDoran> findDoranDoransByUserId(@RequestParam Long userId) {
        return dorandoranService.findDoranDoransByuserId(userId);
    }

    @GetMapping("/findAllDoranDorans")
    public List<DoranDoran> findAllDoranDorans() {
        return dorandoranService.findAllDoranDorans();
    }
}
