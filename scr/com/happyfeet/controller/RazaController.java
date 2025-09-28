package com.happyfeet.controller;

import com.happyfeet.model.entities.Especie;
import com.happyfeet.model.entities.Raza;
import com.happyfeet.service.impl.RazaServiceImpl;
import com.happyfeet.service.interfaces.IRazaService;

import java.util.List;

public class RazaController {

    private final IRazaService razaService;

    public RazaController() {
        this.razaService = new RazaServiceImpl();
    }

    // Registrar nueva raza
    public String registrarRaza(String nombre, int especieId) {
        try {
            Especie especie = new Especie();
            especie.setId(especieId);

            Raza raza = new Raza(0, nombre, especie);
            razaService.registrarRaza(raza);

            return "✅ Raza registrada correctamente.";
        } catch (Exception e) {
            return "❌ Error al registrar raza: " + e.getMessage();
        }
    }

    // Listar todas las razas
    public List<Raza> listarRazas() {
        try {
            return razaService.listarRazas();
        } catch (Exception e) {
            System.out.println("❌ Error al listar razas: " + e.getMessage());
            return null;
        }
    }

    // Buscar raza por ID
    public Raza buscarRazaPorId(Integer id) {
        try {
            return razaService.buscarRazaPorId(id);
        } catch (Exception e) {
            System.out.println("❌ Error al buscar raza con ID " + id + ": " + e.getMessage());
            return null;
        }
    }

    // Actualizar raza
    public String actualizarRaza(int id, String nombre, int especieId) {
        try {
            Especie especie = new Especie();
            especie.setId(especieId);

            Raza raza = new Raza(id, nombre, especie);
            razaService.actualizarRaza(raza);

            return "✅ Raza actualizada correctamente.";
        } catch (Exception e) {
            return "❌ Error al actualizar raza: " + e.getMessage();
        }
    }

    // Eliminar raza
    public String eliminarRaza(Integer id) {
        try {
            razaService.eliminarRaza(id);
            return "🗑️ Raza eliminada correctamente.";
        } catch (Exception e) {
            return "❌ Error al eliminar raza con ID " + id + ": " + e.getMessage();
        }
    }
}
