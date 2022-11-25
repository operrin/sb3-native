package org.miage.intervenantservice.control;

import org.miage.intervenantservice.entity.Intervenant;
import org.springframework.util.StringUtils;

public class IntervenantValidator {
    public static Intervenant validate(Intervenant original, Intervenant modified) {
        if (StringUtils.hasLength(modified.getNom())) {
            original.setNom(modified.getNom());
        }
        if (StringUtils.hasLength(modified.getPrenom())) {
            original.setPrenom(modified.getPrenom());
        }
        if (StringUtils.hasLength(modified.getCommune())) {
            original.setCommune(modified.getCommune());
        }
        if (StringUtils.hasLength(modified.getCodepostal())) {
            original.setCodepostal(modified.getCodepostal());
        }
        return (original);
    }
}
