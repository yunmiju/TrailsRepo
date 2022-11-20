package ubc.cpsc304.domain;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Program {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String programName;
  private int capacity;
  private String imgURL;
  private String description;
  private String managerName;

  public Program() {

  }

  public Program(int id, String programName, int capacity, String imgURL, String description, String managerName) {
    this.id = id;
    this.programName = programName;
    this.capacity = capacity;
    this.imgURL = imgURL;
    this.description = description;
    this.managerName = managerName;
  }
}
