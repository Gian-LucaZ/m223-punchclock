package ch.zli.m223.model;

import javax.persistence.*;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Entry {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Schema(readOnly = true)
  private Long id;

  @Column(nullable = false)
  private LocalDateTime checkIn;

  @Column(nullable = false)
  private LocalDateTime checkOut;

  @ManyToOne(optional = false)
  @JsonIgnoreProperties("entries")
  @Fetch(FetchMode.JOIN)
  private Category category;

  @ManyToOne(optional = false)
  @JsonIgnoreProperties("entries")
  @Fetch(FetchMode.JOIN)
  private ApplicationUser user;

  @ManyToMany
  @JoinTable(
  name = "entry_tags", 
  joinColumns = @JoinColumn(name = "entry_id"), 
  inverseJoinColumns = @JoinColumn(name = "tag_id"))
  @JsonIgnoreProperties("taggedEntries")
  @Fetch(FetchMode.JOIN)
  private List<Tag> tags;

   public ApplicationUser getUser() {
    return user;
  }

  public void setUser(ApplicationUser user) {
    this.user = user;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDateTime getCheckIn() {
    return checkIn;
  }

  public void setCheckIn(LocalDateTime checkIn) {
    this.checkIn = checkIn;
  }

  public LocalDateTime getCheckOut() {
    return checkOut;
  }

  public void setCheckOut(LocalDateTime checkOut) {
    this.checkOut = checkOut;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }
}