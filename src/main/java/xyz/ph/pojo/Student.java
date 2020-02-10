package xyz.ph.pojo;

import java.util.Date;

public class Student {
     private int id;
     private String name;
     private String cla;
     private Date regTime;

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getCla() {
          return cla;
     }

     public void setCla(String cla) {
          this.cla = cla;
     }

     public Date getRegTime() {
          return regTime;
     }

     public void setRegTime(Date regTime) {
          this.regTime = regTime;
     }
}
