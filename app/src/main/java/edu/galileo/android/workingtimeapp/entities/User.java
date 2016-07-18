package edu.galileo.android.workingtimeapp.entities;

import java.util.Map;

/**
 * Created by Hiro on 18/07/2016.
 */
public class User {
    String email;
    Map<String, String> worktimets;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, String> getWorktimets() {
        return worktimets;
    }

    public void setWorktimets(Map<String, String> worktimets) {
        this.worktimets = worktimets;
    }
}
