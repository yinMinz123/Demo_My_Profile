package sg.edu.rp.c346.id20039202.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etName, etGpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGpa = findViewById(R.id.editTextGPA);
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefs.edit();
        prefEditor.putString("name", etName.getText().toString());
        prefEditor.putFloat("gpa", Float.parseFloat(etGpa.getText().toString()));
        prefEditor.commit(); // call commit to save
    }

    @Override
    protected void onResume() {
        super.onResume();

        //on resume is called first
        //retrieve
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String name = prefs.getString("name", "Unknown");
        float gpa = prefs.getFloat("gpa", 0f);
        etName.setText(name);
        etGpa.setText(String.valueOf(gpa));
    }
}