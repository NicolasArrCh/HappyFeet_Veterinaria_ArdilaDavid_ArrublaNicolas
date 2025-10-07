package com.happyfeet.repository.DAO;

import com.happyfeet.model.entities.Mascota;
import com.happyfeet.repository.inter.IMascotaDAO;
import com.happyfeet.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MascotaDAO implements IMascotaDAO {

    private final Map<Integer, Mascota> mapaMascota = new HashMap<>();

    public MascotaDAO() {
        cargarMascotasEnCache();
    }

    @Override
    public void agregarMascota(Mascota mascota) {
        String sql = "INSERT INTO mascotas (dueno_id, nombre, raza_id, fecha_nacimiento, sexo, url_foto) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, mascota.getDuenoId());
            stmt.setString(2, mascota.getNombre());
            stmt.setInt(3, mascota.getRazaId());
            stmt.setDate(4, Date.valueOf(mascota.getFechaNacimiento())); // LocalDate → SQL Date
            stmt.setString(5, mascota.getSexo());
            stmt.setString(6, mascota.getUrlFoto());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    mascota.setId(rs.getInt(1));
                }
            }

            mapaMascota.put(mascota.getId(), mascota);

        } catch (SQLException e) {
            e.printStackTrace(); // luego lo mandamos a logs
        }
    }

    @Override
    public List<Mascota> obtenerTodasMascotas() {

        if (!mapaMascota.isEmpty()) {
            return new ArrayList<>(mapaMascota.values());
        }

        List<Mascota> mascotas = new ArrayList<>();
        String sql = "SELECT * FROM mascotas";
        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Mascota mascota = new Mascota(
                        rs.getInt("id"),
                        rs.getInt("dueno_id"),
                        rs.getString("nombre"),
                        rs.getInt("raza_id"),
                        rs.getDate("fecha_nacimiento").toLocalDate(),
                        rs.getString("sexo"),
                        rs.getString("url_foto")
                );
                mascotas.add(mascota);
                mapaMascota.put(mascota.getId(), mascota);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mascotas;
    }

    @Override
    public Mascota obtenerMascotaPorId(Integer id) {

        if (mapaMascota.containsKey(id)) {
            return mapaMascota.get(id);
        }

        String sql = "SELECT * FROM mascotas WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Mascota mascota = new Mascota(
                        rs.getInt("id"),
                        rs.getInt("dueno_id"),
                        rs.getString("nombre"),
                        rs.getInt("raza_id"),
                        rs.getDate("fecha_nacimiento").toLocalDate(),
                        rs.getString("sexo"),
                        rs.getString("url_foto")
                );
                mapaMascota.put(mascota.getId(), mascota);
                return mascota;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // si no encuentra nada
    }

    @Override
    public void actualizarMascota(Mascota mascota) {
        String sql = "UPDATE mascotas SET dueno_id = ?, nombre = ?, raza_id = ?, fecha_nacimiento = ?, sexo = ?, url_foto = ? WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, mascota.getDuenoId());
            stmt.setString(2, mascota.getNombre());
            stmt.setInt(3, mascota.getRazaId());
            stmt.setDate(4, Date.valueOf(mascota.getFechaNacimiento()));
            stmt.setString(5, mascota.getSexo());
            stmt.setString(6, mascota.getUrlFoto());
            stmt.setInt(7, mascota.getId());
            stmt.executeUpdate();

            mapaMascota.put(mascota.getId(), mascota);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarMascota(Integer id) {
        String sql = "DELETE FROM mascotas WHERE id = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            mapaMascota.remove(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarMascotasEnCache() {
        obtenerTodasMascotas();
    }
}
