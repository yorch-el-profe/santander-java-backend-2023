package org.bedu.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import org.bedu.rest.exception.ContactAlreadyExistsException;
import org.bedu.rest.exception.ContactNotFoundException;
import org.bedu.rest.model.Contact;
import org.bedu.rest.model.UpdatedContact;
import org.bedu.rest.model.response.ErrorResponse;
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
  public ResponseEntity<Object> getContactByName(@PathVariable("name") String name) {
    try {
      return ResponseEntity
          .status(HttpStatus.OK)
          .body(agenda.getOne(name));
    } catch (ContactNotFoundException ex) {
      return ResponseEntity
          .status(HttpStatus.NOT_FOUND)
          .body(new ErrorResponse(name + " does not exist in agenda"));
    }
  }

  // POST /contacts -> Crear un nuevo contacto
  @PostMapping
  // @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Object> createContact(@Valid @RequestBody Contact contact) {
    try {
      return ResponseEntity
          .status(HttpStatus.CREATED)
          .body(agenda.add(contact));
    } catch (ContactAlreadyExistsException ex) {
      return ResponseEntity
          .status(HttpStatus.BAD_REQUEST)
          .body(new ErrorResponse(contact.getName() + " already exists in agenda"));
    }
  }

  // PUT /contacts/{nombre} -> Actualizar un contacto
  @PutMapping("{name}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void updateContact(@Valid @RequestBody UpdatedContact contact,
      @PathVariable("name") String name) {
    agenda.update(name, contact);
  }

  // DELETE /contacts/{nombre}-> Eliminar un contacto
  @DeleteMapping("{name}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteContact(@PathVariable("name") @Size(min = 3) String name) {
    agenda.remove(name);
  }
}
