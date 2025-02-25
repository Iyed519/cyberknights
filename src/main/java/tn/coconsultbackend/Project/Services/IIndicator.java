package tn.coconsultbackend.Project.Services;

import tn.coconsultbackend.Model.Indicator;

import java.util.List;
import java.util.Optional;

public interface IIndicator {
    List<Indicator> getAllIndicators();
    Optional<Indicator> getIndicatorById(Long id);
    Indicator saveIndicator(Indicator indicator);
    void deleteIndicator(Long id);
}
