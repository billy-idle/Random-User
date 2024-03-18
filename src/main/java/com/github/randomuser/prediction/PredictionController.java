package com.github.randomuser.prediction;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/api/random-user")
@RequiredArgsConstructor
class PredictionController {

    private final PredictionService predictionService;

    @GetMapping
    Map<String, Object> getPrediction() {
        return predictionService.query();
    }
}
