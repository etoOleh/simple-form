package com.simpleform.simpleform.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="date_table")
public class DateModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String worker;

    String day;

    String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateModel dateModel = (DateModel) o;
        return Objects.equals(id, dateModel.id) && Objects.equals(worker, dateModel.worker) && Objects.equals(day, dateModel.day) && Objects.equals(time, dateModel.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, worker, day, time);
    }

    @Override
    public String toString() {
        return "DateModel{" +
                "id=" + id +
                ", worker='" + worker + '\'' +
                ", day='" + day + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
