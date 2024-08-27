package br.com.acme.insurancequote.service.impl;

import br.com.acme.insurancequote.exception.CustomException;
import br.com.acme.insurancequote.service.AssistenceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssistenceServiceImpl implements AssistenceService {
    @Override
    public void validInformedAssistences(List<String> assistences, List<String> assistencesInformed) {
        List<String> diference = new ArrayList<>(assistencesInformed);
        diference.removeAll(assistences);

        if (!diference.isEmpty())
            throw new CustomException("Assistência informada não disponível " + diference);

    }
}
