package kz.nkoldassov.apiqueue.controller;

import kz.nkoldassov.apiqueue.service.ScoreboardCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scoreboard")
public class ScoreboardCodeController {

    private final ScoreboardCodeService service;

    @Autowired
    public ScoreboardCodeController(ScoreboardCodeService service) {
        this.service = service;
    }

    @GetMapping("/get-next-code")
    public ResponseEntity<?> getNextCode() {
        String nextCode = service.getNextCode();
        return ResponseEntity.ok(nextCode);
    }
}
