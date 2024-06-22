package com.samyakj820.smart_contact_manager.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
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
public class User implements UserDetails{

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
   private Boolean enabled=true;
   private Boolean emailVerified = false;
   private Boolean phoneVerified = false;

   @Enumerated(value = EnumType.STRING)
   private Providers provider = Providers.SELF;
   private String providerUserId;

   @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private List<Contact> contacts = new ArrayList<>();

   @ElementCollection(fetch = FetchType.EAGER)
   private List<String> roleList = new ArrayList<>();

   @Override
   public Collection<? extends GrantedAuthority> getAuthorities() {
      Collection<SimpleGrantedAuthority> roles = roleList.stream().map(role-> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
      return roles;
   }

   @Override
   public String getUsername() {
      return this.email;
   }


}
