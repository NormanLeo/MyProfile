package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etName, etGPA;
    RadioGroup rgGender;

    @Override
    protected void onPause() {
        super.onPause();

        String strName = etName.getText().toString();
        float flGPA = Float.parseFloat(etGPA.getText().toString());
        int intGender = rgGender.getCheckedRadioButtonId();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("name", strName);
        prefEdit.putFloat("GPA", flGPA);
        prefEdit.putInt("gender", intGender);
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String msg = prefs.getString("name", "No Name!");
        float GPA = prefs.getFloat("GPA", 0.0f);
        int Gender = prefs.getInt("gender", 0);
        etName.setText(msg);
        etGPA.setText(String.valueOf(GPA));
        rgGender.check(Gender);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);
        rgGender = findViewById(R.id.radioGroupGender);


    }
}
