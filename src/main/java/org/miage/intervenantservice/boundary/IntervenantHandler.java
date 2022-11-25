package org.miage.intervenantservice.boundary;

import java.net.URI;
import org.miage.intervenantservice.control.IntervenantValidator;
import org.miage.intervenantservice.control.IntervenantService;
import org.miage.intervenantservice.entity.Intervenant;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class IntervenantHandler {

    private final IntervenantService is;

    IntervenantHandler(IntervenantService is) {
        this.is = is;
    }

    Mono<ServerResponse> getAllIntervenants(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(is.getIntervenants(), Intervenant.class);
    }

    public Mono<ServerResponse> getIntervenantById(ServerRequest request) {
        return this.is.getIntervenant(request.pathVariable("id"))
                .flatMap(r -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(r))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    @Transactional
    public Mono<ServerResponse> saveIntervenant(ServerRequest request) {
        return request.bodyToMono(Intervenant.class)
                .flatMap(is::createIntervenant)
                .flatMap(r -> ServerResponse.created(URI.create("/intervenants/" + r.getId())).build());
    }

    @Transactional
    public Mono<ServerResponse> deleteIntervenant(ServerRequest request) {
        return ServerResponse.noContent().build(this.is.deleteIntervenant(request.pathVariable("id")));
    }

    @Transactional
    public Mono<ServerResponse> updateIntervenant(ServerRequest request) {
        return this.is.getIntervenant(request.pathVariable("id"))
                .flatMap(r -> Mono
                        .zip(data -> IntervenantValidator.validate((Intervenant) data[0], (Intervenant) data[1]),
                                this.is.getIntervenant(request.pathVariable("id")),
                                request.bodyToMono(Intervenant.class))
                        .flatMap(is::createIntervenant)
                        .flatMap(f -> ServerResponse.ok().build())
                        .switchIfEmpty(ServerResponse.badRequest().build()))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
