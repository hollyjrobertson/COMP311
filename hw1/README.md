  ### [HW1](https://github.com/hollyjrobertson/COMP311/tree/master/hw1 "HW1")
  #### Problem:  
  Write a simple adapter class to translate between these two interfaces:
  
  ```java 
  public interface Student {
    int getId();
    void setId(int id);
    String getFirstName();
    void setFirstName(String firstName);
    String getLastName();
    void setLastName(String lastName);
  }

  public interface LegacyStudent {
    String getId();
    void setId(String id);
    String getFullName();
    void setFullName(String name);
  }
