package com.pieropan.clean.domain;

import com.pieropan.clean.infra.persistence.jpa.UsuarioEntity;

import java.util.List;

public record Usuario(Long id, String nome, String email, String senha) {

    public static List<Usuario> toUsuario(List<UsuarioEntity> usuarios) {
        return usuarios.stream().map(Usuario::toUsuario).toList();
    }

    public static Usuario toUsuario(Usuario usuario, Long id) {
        return new Usuario(id, usuario.nome(), usuario.email(), usuario.senha());
    }

    public static Usuario toUsuario(UsuarioEntity usuario) {
        return new Usuario(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getSenha());
    }

    public static UsuarioEntity toUsuarioEntity(Usuario usuario) {
        return new UsuarioEntity(usuario.id, usuario.nome, usuario.email, usuario.senha);
    }
}