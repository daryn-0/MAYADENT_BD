package com.mayadent.MAYADENTBD.repository;

import com.mayadent.MAYADENTBD.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
