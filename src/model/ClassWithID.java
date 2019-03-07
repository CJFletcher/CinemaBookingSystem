package model;

// Taken and modified from:
// https://stackoverflow.com/questions/8938528/how-do-i-get-a-unique-id-per-object-in-java

import java.util.concurrent.atomic.AtomicLong;

public abstract class ClassWithID {
    private static final AtomicLong NEXT_ID = new AtomicLong(1);
    private final long id = NEXT_ID.getAndIncrement();

    public long getId() {
        return id;
    }
}
