package org.bedu.lombokdemo.model;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// @Data: Es la abreviación de @Getter, @Setter, @ToString, @EqualsAndHashCode, así como la generación de un constructor con todos los atributos (SOLO SI NO SE USA LAS ANOTACIONES DE CONSTRUCTOR)
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = { "username" }) // Los objetos serán iguales sólo por
// el campo username
// @NoArgsConstructor // Crea un constructor vacío
// @RequiredArgsConstructor // Crea un constructor con los atributos
// obligatorios (@NonNull o final)
@AllArgsConstructor // Crea un constructor con literalmente todos los
// atributos
@Builder // Implementa el patrón de creación "builder"
public class User {
  // @NonNull // Declaramos el atributo como obligatorio
  private String username;

  // @NonNull // Declaramos el atributo como obligatorio
  private String mail;

  private String password;
  private String address;
  private int age;

  // "Y" -> true, "N" -> false
  private String activated;
}
