package com.samyakj820.smart_contact_manager.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {

   @Id
   private String userId;
   private String name;
   @Column(unique = true, nullable = false)
   private String email;
   private String password;
   @Column(length = 1000)
   private String about;
   private String profilePic;
   private String phoneNumber;

   // Info
   private Boolean enabled=false;
   private Boolean emailVerified = false;
   private Boolean phoneVerified = false;

   @Enumerated(value = EnumType.STRING)
   private Providers provider = Providers.SELF;
   private String providerUserId;

   @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private List<Contact> contacts = new ArrayList<>();


}
