package ru.mirea.vikulov.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import ru.mirea.vikulov.lesson6.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences sharedPref = getSharedPreferences("settings-vikulov",	Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        binding.goB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("GROUP", String.valueOf(binding.editGroup.getText()));
                editor.putInt("NUMBER", Integer.parseInt(String.valueOf(binding.editStudent.getText())));
                editor.putString("MOVIE", String.valueOf(binding.editFilm.getText()));
                editor.apply();
            }
        });

        binding.editGroup.setText(sharedPref.getString("GROUP", "BSBO"));
        binding.editStudent.setText(String.valueOf(sharedPref.getInt("NUMBER", 1)));
        binding.editFilm.setText(sharedPref.getString("MOVIE", "No film"));
    }
}