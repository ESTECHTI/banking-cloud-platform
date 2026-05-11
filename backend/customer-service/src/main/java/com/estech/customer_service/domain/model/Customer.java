package com.estech.customer_service.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.regex.Pattern;

public class Customer {

  private UUID id;
  private String name;
  private String email;
  private LocalDateTime createdAt;

  private static final Pattern EMAIL_PATTERN = Pattern.compile(
      "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$",
      Pattern.CASE_INSENSITIVE);

  public Customer(String name, String email) {
    this.id = UUID.randomUUID();
    changeName(name);
    changeEmail(email);
    this.createdAt = LocalDateTime.now();
  }

  private void validateName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Name cannot be null or empty");
    }
  }

  private void validateEmail(String email) {
    if (email == null || email.trim().isEmpty()) {
      throw new IllegalArgumentException("Email cannot be null or empty");
    }

    if (!EMAIL_PATTERN.matcher(email.trim()).matches()) {
      throw new IllegalArgumentException("Email format is invalid");
    }
  }

  public UUID getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  private void setName(String name) {
    validateName(name);
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  private void setEmail(String email) {
    validateEmail(email);
    this.email = email;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void changeName(String name) {
    setName(name);
  }

  public void changeEmail(String email) {
    setEmail(email);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Customer other = (Customer) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
}
