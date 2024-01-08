package co.com.ufps.usecase.convocation;

import co.com.ufps.model.convocation.Convocation;
import co.com.ufps.model.convocation.gateways.ConvocationRepository;
import co.com.ufps.usecase.TestBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConvocationUseCaseTest {
    @InjectMocks
    private ConvocationUseCase convocationUseCase;
    @Mock
    private ConvocationRepository convocationRepository;

    @Test
    void save() {
        Convocation convocation = TestBuilder.convocation();
        convocation.setId(null);
        when(convocationRepository.findCurrentConvocation()).thenReturn(null);
        when(convocationRepository.save(convocation)).thenReturn(convocation);

        Convocation response = convocationUseCase.save(convocation);

        assertEquals(convocation, response);
        verify(convocationRepository).findCurrentConvocation();
        verify(convocationRepository).save(convocation);
    }

    @Test
    void findAll() {
        Convocation convocation = TestBuilder.convocation();
        when(convocationRepository.findAll()).thenReturn(List.of(convocation));

        List<Convocation> response = convocationUseCase.findAll();

        assertEquals(List.of(convocation), response);
        verify(convocationRepository).findAll();
    }

    @Test
    void findById() {
        Convocation convocation = TestBuilder.convocation();
        when(convocationRepository.findById(convocation.getId())).thenReturn(convocation);

        Convocation response = convocationUseCase.findById(convocation.getId());

        assertEquals(convocation, response);
        verify(convocationRepository).findById(convocation.getId());
    }

    @Test
    void findCurrentConvocation() {
        Convocation convocation = TestBuilder.convocation();
        when(convocationRepository.findCurrentConvocation()).thenReturn(convocation);

        Convocation response = convocationUseCase.findCurrentConvocation();

        assertEquals(convocation, response);
        verify(convocationRepository).findCurrentConvocation();
    }
}