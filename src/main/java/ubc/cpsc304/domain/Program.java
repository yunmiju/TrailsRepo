package ubc.cpsc304.domain;

import lombok.Data;

@Data
public class Program {
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
