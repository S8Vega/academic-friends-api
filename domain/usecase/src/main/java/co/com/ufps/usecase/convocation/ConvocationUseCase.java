package co.com.ufps.usecase.convocation;

import co.com.ufps.model.convocation.Convocation;
import co.com.ufps.model.convocation.gateways.ConvocationRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConvocationUseCase {
    private final ConvocationRepository convocationRepository;

    public Convocation save(Convocation convocation) {
        return convocationRepository.save(convocation);
    }
}
