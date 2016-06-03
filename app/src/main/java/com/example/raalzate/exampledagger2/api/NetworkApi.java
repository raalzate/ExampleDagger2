package com.example.raalzate.exampledagger2.api;

/**
 * Created by raul-alzate on 3/06/16.
 */
public class NetworkApi {

    public boolean validateUser(String username, String password) {
        // imagine an actual network call here
        // for demo purpose return false in "real" life
        if (username == null || username.length() == 0) {
            return false;
        } else {
            return true;
        }
    }
}
