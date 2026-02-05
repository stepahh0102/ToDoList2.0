package org.example;

public class Task {
    public int id;
    public String text;
    public boolean done;

    public Task(int id, String text) {
        this.id = id;
        this.text = text;
        this.done = false;
    }

    public String toString() {
        if (done) {
            return id + ". [X] " + text;
        } else {
            return id + ". [ ] " + text;
        }
    }
}
