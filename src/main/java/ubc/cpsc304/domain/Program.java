package ubc.cpsc304.domain;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Program {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;
  private int capacity;
  private String imgURL;
  private String description;
  private String managerName;

  public Program() {

  }

  public Program(int id, String name, int capacity, String imgURL, String description, String managerName) {
    this.id = id;
    this.name = name;
    this.capacity = capacity;
    this.imgURL = imgURL;
    this.description = description;
    this.managerName = managerName;
  }
}
