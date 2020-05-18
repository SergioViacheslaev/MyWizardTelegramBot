package ru.home.mywizard_bot.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * Данные анкеты пользователя
 */

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProfileData implements Serializable {
    String name;
    String gender;
    String color;
    String movie;
    String song;
    int age;
    int number;


    @Override
    public String toString() {
        return String.format("Имя: %s%nВозраст: %d%nПол: %s%nЛюбимая цифра: %d%n" +
                        "Цвет: %s%nФильм: %s%nПесня: %s%n", getName(), getAge(), getGender(), getNumber(),
                getColor(), getMovie(), getSong());
    }
}
