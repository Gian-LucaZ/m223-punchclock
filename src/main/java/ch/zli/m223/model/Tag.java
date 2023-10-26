package ch.zli.m223.model;

import java.util.List;

import javax.persistence.*;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(readOnly = true)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<Entry> taggedEntries;

    public List<Entry> getTaggedEntries() {
        return taggedEntries;
    }

    public void setTaggedEntries(List<Entry> taggedEntries) {
        this.taggedEntries = taggedEntries;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
