package tn.coconsultbackend.Project.Services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.coconsultbackend.Model.Indicator;
import tn.coconsultbackend.Project.Repositories.IndicatorRepository;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
@Slf4j
public class IndicatorService implements IIndicator{
    @Autowired
    private IndicatorRepository indicatorRepository;

    @Override
    public List<Indicator> getAllIndicators() {
        return indicatorRepository.findAll();
    }

    @Override
    public Optional<Indicator> getIndicatorById(Long id) {
        return indicatorRepository.findById(id);
    }

    @Override
    public Indicator saveIndicator(Indicator indicator) {
        return indicatorRepository.save(indicator);
    }

    @Override
    public void deleteIndicator(Long id) {
        indicatorRepository.deleteById(id);
    }

}
