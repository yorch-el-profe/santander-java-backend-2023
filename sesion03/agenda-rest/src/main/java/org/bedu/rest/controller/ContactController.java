package org.bedu.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

import java.util.List;

import org.bedu.rest.model.Contact;
import org.bedu.rest.model.UpdatedContact;
import org.bedu.rest.service.AgendaService;

@RestController
@RequestMapping("contacts")
@Validated
public class ContactController {

  private AgendaService agenda;

  @Autowired
  public ContactController(AgendaService agenda) {
    this.agenda = agenda;
  }

  // GET /contacts -> Obtener toda la agenda
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Contact> getContacts() {
    return agenda.getAll();
  }

  // GET /contacts/{nombre} -> Obtener un contacto en particular
  // GET /contacts/maria -> 5543231450
  @GetMapping("{name}")
  public Contact getContactByName(@PathVariable("name") String name) {
    return agenda.getOne(name);
  }

  // POST /contacts -> Crear un nuevo contacto
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Contact createContact(@Valid @RequestBody Contact contact) {
    return agenda.add(contact);
  }

  // PUT /contacts/{nombre} -> Actualizar un contacto
  @PutMapping("{name}")
  public void updateContact(@Valid @RequestBody UpdatedContact contact,
      @PathVariable("name") String name) {
    agenda.update(name, contact);
  }

  // DELETE /contacts/{nombre}-> Eliminar un contacto
  @DeleteMapping("{name}")
  public void deleteContact(@PathVariable("name") @Size(min = 3) String name) {
    agenda.remove(name);
  }
}
