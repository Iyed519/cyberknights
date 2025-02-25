package tn.coconsultbackend.Project.RestController;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.coconsultbackend.Model.Indicator;
import tn.coconsultbackend.Project.Services.IIndicator;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/indicators")
public class IndicatorRestController {
    @Autowired
    private IIndicator indicatorService;

    @GetMapping
    public List<Indicator> getAllIndicators() {
        return indicatorService.getAllIndicators();
    }

    @GetMapping("/{id}")
    public Optional<Indicator> getIndicatorById(@PathVariable Long id) {
        return indicatorService.getIndicatorById(id);
    }

    @PostMapping
    public Indicator createIndicator(@RequestBody Indicator indicator) {
        return indicatorService.saveIndicator(indicator);
    }

    @PutMapping("/{id}")
    public Indicator updateIndicator(@PathVariable Long id, @RequestBody Indicator indicator) {
        indicator.setIndicatorId(id);
        return indicatorService.saveIndicator(indicator);
    }

    @DeleteMapping("/{id}")
    public void deleteIndicator(@PathVariable Long id) {
        indicatorService.deleteIndicator(id);
    }
}
