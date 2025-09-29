package com.happyfeet.controller;

import com.happyfeet.model.entities.Especie;
import com.happyfeet.service.impl.EspecieServiceImpl;

import java.util.List;

public class EspeciesController {

    private EspecieServiceImpl especieService;

    public EspeciesController() {
        this.especieService = new EspecieServiceImpl();
    }

    // Crear nueva especie
    public String agregarEspecie(String nombre) {
        try {
            Especie especie = new Especie(0, nombre);
            especieService.agregarEspecie(especie);
            return "✅ Especie registrada con éxito.";
        } catch (Exception e) {
            return "❌ Error al registrar especie: " + e.getMessage();
        }
    }

    // Consultar todas las especies
    public List<Especie> obtenerTodasEspecies() {
        try {
            return especieService.obtenerTodasEspecies();
        } catch (Exception e) {
            System.out.println("❌ Error al listar especies: " + e.getMessage());
            return null;
        }
    }

    // Consultar por ID
    public Especie obtenerEspeciePorId(int id) {
        try {
            return especieService.obtenerEspeciePorId(id);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
            return null;
        }
    }

    // Consultar por nombre
    public Especie obtenerPorNombre(String nombre) {
        try {
            return especieService.obtenerPorNombre(nombre);
        } catch (Exception e) {
            System.out.println("❌ " + e.getMessage());
            return null;
        }
    }

    // Actualizar especie
    public String actualizarEspecie(int id, String nombre) {
        try {
            Especie especie = new Especie(id, nombre);
            especieService.actualizarEspecie(especie);
            return "✅ Especie actualizada correctamente.";
        } catch (Exception e) {
            return "❌ Error al actualizar especie: " + e.getMessage();
        }
    }

    // Eliminar especie
    public String eliminarEspecie(int id) {
        try {
            especieService.eliminarEspecie(id);
            return "🗑️ Especie eliminada correctamente.";
        } catch (Exception e) {
            return "❌ Error al eliminar especie: " + e.getMessage();
        }
    }
}
