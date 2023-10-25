package ch.zli.m223.validator;

import ch.zli.m223.exceptions.InvalidEntryException;
import ch.zli.m223.model.Entry;

public class Validate {

    private boolean isValid;
    
    public Validate entry(Entry e){
        isValid = e.getCheckOut().isAfter(e.getCheckIn());
        return this;
    }

    public void throwIfInvalid(){
        if (!isValid) {
            throw new InvalidEntryException();
        }
    }
}
