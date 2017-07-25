package pl.legalnyplener.shoppinglist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RegisterActivity extends Activity {

    private EditText usernameField, passwordField, emailField;
    private TextView  role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_register);

        usernameField = (EditText) findViewById(R.id.editText1);
        passwordField = (EditText) findViewById(R.id.editText2);
        emailField = (EditText) findViewById(R.id.email_input);


        role = (TextView) findViewById(R.id.textView7);

    }


    public void Register (View view) {
        String username = usernameField.getText().toString() ;
        String password = passwordField.getText().toString();
        String email = emailField.getText().toString();

       String passwordHash =  md5(password);  //przypisanie pobranego hasła do metody md5

        new Register(this, role, 0).execute(username, passwordHash, email);   // przesylanie danych do nowego activity

    }





    public String md5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");    //md5  metoda # haasła
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
