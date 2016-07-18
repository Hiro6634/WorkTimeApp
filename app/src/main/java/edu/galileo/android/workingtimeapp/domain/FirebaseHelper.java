package edu.galileo.android.workingtimeapp.domain;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Hiro on 17/07/2016.
 */
public class FirebaseHelper {
    private DatabaseReference dataReference;
    private final static String USERS_PATH = "USERS";
    private final static String TIMESTAMP_PATH = "TIMESTAMP";

    private static class SingletonHolder{
        private final static FirebaseHelper INSTANCE = new FirebaseHelper();
    }

    public static FirebaseHelper getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public FirebaseHelper() {
        this.dataReference = FirebaseDatabase.getInstance().getReference();
    }

    public DatabaseReference getDataReference(){
        return this.dataReference;
    }

    public String getAuthUserEmail() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = null;
        if(user != null){
            email = user.getEmail();
        }
        return email;
    }

    public DatabaseReference getUserReference(String email){
        DatabaseReference userReference = null;

        if( email != null){
            String emailKey = email.replace(".","_");
            userReference = dataReference.getRoot().child(USERS_PATH).child(emailKey);
        }
        return userReference;
    }

    public DatabaseReference getMyUserReference(){
        return getUserReference(getAuthUserEmail());
    }
}
