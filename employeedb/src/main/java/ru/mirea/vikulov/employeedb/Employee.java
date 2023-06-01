package ru.mirea.vikulov.employeedb;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Employee {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;
    public String power;
    public int age;
    public long getId() {
        return id;
    }

    public String getName() {
        return String.valueOf(name);
    }

    public String getPower() {
        return String.valueOf(power);
    }
    public String getAge(){return String.valueOf(age);}
}
