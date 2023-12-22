package co.com.ufps.model.convocation.gateways;

import co.com.ufps.model.convocation.Convocation;

import java.util.List;

public interface ConvocationRepository {
    Convocation save(Convocation convocation);

    List<Convocation> findAll();

    Convocation findById(Long id);
}
