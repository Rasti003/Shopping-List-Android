package pl.legalnyplener.shoppinglist;

        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;

        import java.security.MessageDigest;
        import java.security.NoSuchAlgorithmException;

public class SigninActivity extends Activity {

    private EditText usernameField,passwordField;
    private TextView role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        usernameField = (EditText)findViewById(R.id.editText1);
        passwordField = (EditText)findViewById(R.id.editText2);


        role = (TextView)findViewById(R.id.textView7);

    }



    public void login(View view){
        String username = usernameField.getText().toString();
        String password = passwordField.getText().toString();
        String paswordHash = md5(password);
        new Signin(this,role,0).execute(username,paswordHash);

    }

    public void RegisterBtn(View view){

        Intent intent = new Intent(getApplicationContext(),RegisterActivity.class); //PRZENOSZENIE NA INNE ACTIVITY: twozenie INTENS getApp..- aktualny kontekst aplikacje przycisk powrót tu przeniesie , Activity docelowe.class
      startActivity(intent);

    }


   /* public void loginPost(View view){
        String username = usernameField.getText().toString();            /ogowanie za posrednictwem metody post
        String password = passwordField.getText().toString();
        method.setText("Post Method");
        new Signin(this,status,role,1).execute(username,password);
    }*/

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