package com.example.ppidpo.server;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/private/producer")
public class privateProducer {
    private ResponseEntity answer(HttpServletRequest request, Integer producer_id) {
        String value = request.getParameter("value");
        try {
            return ResponseEntity.ok("{Instanceld: \"Producer-"+ String.valueOf(producer_id) +
                    "\", USD:\"" + String.valueOf(Float.parseFloat(value)/100)+"\"}");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Some error happened");
        }
    }
    @GetMapping("/a1")
    public ResponseEntity getHand1(HttpServletRequest request) {
        return answer(request, 1);
    }

    @GetMapping("/a2")
    public ResponseEntity getHand2(HttpServletRequest request) {
        return answer(request, 2);
    }

    @GetMapping("/a3")
    public ResponseEntity getHand3(HttpServletRequest request) {
        return answer(request, 3);
    }
}
