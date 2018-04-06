package com.techkshetrainfo.loginotp;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.techkshetrainfo.loginotp.Models.OptResponse;
import com.techkshetrainfo.loginotp.Restapi.ApiClient;
import com.techkshetrainfo.loginotp.Restapi.GetApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText phone;
    Button submit;
    String otp_server;
    Dialog myDialog;
    boolean register_user = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone = (EditText) findViewById(R.id.login_phone);
        submit = (Button) findViewById(R.id.btn_login);
        SharedPreferences log_sesion = getSharedPreferences("log_session", MODE_PRIVATE);

        String loggedin = log_sesion.getString("loggedin", "0");
        if (loggedin.equals("0")) {
            register_user = false;
        } else {
            register_user = true;
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (CommomFunctions.isnetworkavailable(MainActivity.this)) {
                    getotp();
                } else {
                    CommomFunctions.show_dialog(MainActivity.this, getString(R.string.internet_error_title), getString(R.string.internet_error));
                }
            }
        });
      /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
    }

    private void getotp() {
        final ProgressDialog progress = new ProgressDialog(MainActivity.this);
        progress.setMessage(getString(R.string.loading_msg));
        progress.show();
        GetApi apiService = ApiClient.getClient().create(GetApi.class);
        Call<OptResponse> call = apiService.getopt(phone.getText().toString());
        call.enqueue(new Callback<OptResponse>() {
            @Override
            public void onResponse(Call<OptResponse> call, Response<OptResponse> response) {
                progress.dismiss();
                String status_code = response.body().getStatus().getCode();
                if (status_code.equals("101")) {
                    otp_server = response.body().getOpt().getOtpCode();
                    callLoginDialog();
                }
            }

            @Override
            public void onFailure(Call<OptResponse> call, Throwable t) {
                progress.dismiss();
                CommomFunctions.show_dialog(MainActivity.this, getString(R.string.internet_error_title), getString(R.string.internet_error));
            }
        });
    }

    private void callLoginDialog() {
        myDialog = new Dialog(MainActivity.this);
        myDialog.setContentView(R.layout.otp_popup);
        myDialog.setCancelable(true);
        Button otp_sub = (Button) myDialog.findViewById(R.id.otp_sub);
        final EditText otp = (EditText) myDialog.findViewById(R.id.otp);
        // password = (EditText) myDialog.findViewById(R.id.yourpasswordID);
        myDialog.show();
        otp_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (otp.getText().toString().equals(otp_server)) {
                    SharedPreferences.Editor editor = getSharedPreferences("log_session", MODE_PRIVATE).edit();
                    editor.putString("loggedin", "1");
                    editor.putString("contact_no", phone.getText().toString());
                    editor.putString("user_name", "User");
                    editor.commit();
//                    startActivity(new Intent(MainActivity.this, StatusActivity.class));
                    myDialog.dismiss();
                } else {
                    Toast.makeText(MainActivity.this, R.string.incorrect_otp, Toast.LENGTH_SHORT).show();
                    myDialog.dismiss();
                }
                //your login calculation goes here
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.logout) {
//            SharedPreferences.Editor editor = getSharedPreferences("log_session", MODE_PRIVATE).edit();
//            editor.putString("loggedin", "0");
//            editor.putString("contact_no", "");
//            editor.putString("user_name", "");
//            editor.commit();
//            finish();
//            startActivity(getIntent());
//        }
//        if (id == R.id.contact_us) {
//            /*Bundle bundle = new Bundle();
//            bundle.putString("message", " ");
//            Intent login_intent= new Intent(MainActivity.this,MainActivity.class);
//            login_intent.putExtras(bundle);
//            startActivity(login_intent);*/
//        }
//        if (id == R.id.about) {
//
//        }
//        if (id == R.id.login) {
//            Intent login_intent = new Intent(MainActivity.this, MainActivity.class);
//            startActivity(login_intent);
//        }
//        if (id == R.id.status) {
//
//            Intent login_intent = new Intent(MainActivity.this, StatusActivity.class);
//            startActivity(login_intent);
//        }
//
//
//        return super.onOptionsItemSelected(item);
//    }

//    public boolean onPrepareOptionsMenu(Menu menu) {
//        MenuItem register = menu.findItem(R.id.logout);
//        MenuItem login = menu.findItem(R.id.login);
//        MenuItem status_menu = menu.findItem(R.id.status);
//        if (!register_user) {
//            register.setVisible(false);
//            status_menu.setVisible(false);
//            login.setVisible(true);
//        } else {
//            register.setVisible(true);
//            status_menu.setVisible(true);
//            login.setVisible(false);
//        }
//        return true;
//    }
}