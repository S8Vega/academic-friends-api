package co.com.ufps.usecase.convocation;

import co.com.ufps.model.convocation.Convocation;
import co.com.ufps.model.convocation.gateways.ConvocationRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ConvocationUseCase {
    private final ConvocationRepository convocationRepository;

    public Convocation save(Convocation convocation) {
        return convocationRepository.save(convocation);
    }

    public List<Convocation> findAll() {
        return convocationRepository.findAll();
    }

    public Convocation findById(Long id) {
        return convocationRepository.findById(id);
    }

    public Convocation findCurrentConvocation() {
        return convocationRepository.findCurrentConvocation();
    }
}
