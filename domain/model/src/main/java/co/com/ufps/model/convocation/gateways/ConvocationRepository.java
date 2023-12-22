package co.com.ufps.model.convocation.gateways;

import co.com.ufps.model.convocation.Convocation;

public interface ConvocationRepository {
    Convocation save(Convocation convocation);
}
