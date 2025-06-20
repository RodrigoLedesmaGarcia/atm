package com.spring.www.atm.service;

import com.spring.www.atm.entity.Cajero;

import java.util.List;
import java.util.Map;


public interface CajeroService {

    List<Map<String, Object>> retirarEfectivo ( double monto);

    double obtenerSaldoDisponible();

    List<Cajero> listar();
}
