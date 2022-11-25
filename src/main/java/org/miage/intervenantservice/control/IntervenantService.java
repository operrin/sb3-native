package org.miage.intervenantservice.control;

import java.util.UUID;

import org.miage.intervenantservice.boundary.IntervenantRepository;
import org.miage.intervenantservice.entity.Intervenant;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class IntervenantService {

  private final IntervenantRepository intervenantRepository;

  public IntervenantService(IntervenantRepository intervenantRepository) {
    this.intervenantRepository = intervenantRepository;
  }

  public Mono<Intervenant> createIntervenant(Intervenant intervenant) {
    return intervenantRepository.save(intervenant);
  }

  public Flux<Intervenant> getIntervenants() {
    return intervenantRepository.findAll();
  }

  public Mono<Intervenant> getIntervenant(String id) {
    return intervenantRepository.findById(UUID.fromString(id));
  }

  public Mono<Void> deleteIntervenant(String id) {
    return intervenantRepository.deleteById(UUID.fromString(id));
  }
}
