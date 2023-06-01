package ru.mirea.vikulov.employeedb;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Toast;

import ru.mirea.vikulov.employeedb.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppDatabase db = App.getInstance().getDatabase();
        EmployeeDao employeeDao = db.employeeDao();
        binding.findB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.editID.getText().length() != 0) {
                    Employee employee;
                    employee = employeeDao.getById(Long.parseLong(String.valueOf(binding.editID.getText())));
                    binding.editName.setText(employee.getName());
                    binding.editPow.setText(employee.getPower());
                    binding.editAge.setText(employee.getAge());
                } else {
                    Toast.makeText(getApplicationContext(), "Введите id", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.saveB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.editID.getText().length() != 0 & binding.editName.getText().length() != 0 & binding.editPow.getText().length() != 0 & binding.editAge.getText().length() != 0) {
                    try {
                        Employee employee = new Employee();
                        employee.id = Long.parseLong(String.valueOf(binding.editID.getText()));
                        employee.name = String.valueOf(binding.editName.getText());
                        employee.power = String.valueOf(binding.editPow.getText());
                        employee.age = Integer.parseInt(String.valueOf(binding.editAge.getText()));
                        employeeDao.insert(employee);
                    } catch (SQLiteConstraintException e) {
                        Toast.makeText(getApplicationContext(), "такой id уже есть", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Заполните поля до конца", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.updB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.editID.getText().length() != 0 & binding.editName.getText().length() != 0 & binding.editPow.getText().length() != 0 & binding.editAge.getText().length() != 0) {
                    try {
                        Employee employee = new Employee();
                        employee.id = Long.parseLong(String.valueOf(binding.editID.getText()));
                        employee.name = String.valueOf(binding.editName.getText());
                        employee.power = String.valueOf(binding.editPow.getText());
                        employee.age = Integer.parseInt(String.valueOf(binding.editAge.getText()));
                        employeeDao.update(employee);
                    } catch (SQLiteConstraintException e) {
                        Toast.makeText(getApplicationContext(), "id already in use", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Заполните поля до конца", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}
