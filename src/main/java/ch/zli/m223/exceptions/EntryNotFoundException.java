package ch.zli.m223.exceptions;

public class EntryNotFoundException extends IllegalStateException {
    
    public EntryNotFoundException(Long id) {
        super(String.format("Entry with Id: %s not found", id));
    }
}
