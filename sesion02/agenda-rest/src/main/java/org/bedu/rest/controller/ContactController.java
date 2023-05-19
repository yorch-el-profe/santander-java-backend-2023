package org.bedu.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.bedu.rest.model.Contact;

@RestController
@RequestMapping("contacts")
public class ContactController {

  private Map<String, Contact> agenda;

  public ContactController() {
    agenda = new HashMap<String, Contact>();

    agenda.put("maria", new Contact("Maria", "5543231450"));
    agenda.put("pablo", new Contact("Pablo", "5648203910"));
  }

  // GET /contacts -> Obtener toda la agenda
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Contact> getContacts() {
    return new LinkedList<Contact>(agenda.values());
  }

  // GET /contacts/nombre -> Obtener un contacto en particular
  // GET /contacts/maria -> 5543231450
  @GetMapping("{name}")
  public ResponseEntity<Contact> getContactByName(@PathVariable("name") String name) {
    if (!agenda.containsKey(name)) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    return ResponseEntity.status(HttpStatus.OK).body(agenda.get(name.toLowerCase()));
  }

  // POST /contacts -> Crear un nuevo contacto
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Contact createContact(@RequestBody Contact newContact) {
    agenda.put(newContact.getName().toLowerCase(), newContact);
    return newContact;
  }

  // PUT /contacts/nombre -> Actualizar un contacto
  // DELETE /contacts/nombre -> Eliminar un contacto
}
