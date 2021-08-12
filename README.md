# Course Work ( COMP311 )

### [Lab 2](https://github.com/hollyjrobertson/COMP311/tree/master/Lab2 "Lab 2")
  #### Purpose:   
  Focus on the tree structures, recursion, and the [Visitor](https://www.tutorialspoint.com/design_pattern/visitor_pattern.htm "Visitor"), [Strategy](https://www.tutorialspoint.com/design_pattern/strategy_pattern.html "Strategy") and   
   [Composite design patterns.](https://www.tutorialspoint.com/design_pattern/composite_pattern.htm "Composite")
   #### Assignment:  
   Using the Visitor and Composite patterns to perform  
   specific operations on the data stored in a git repository.
   #### Details:  
   Utilized the Visitor to maintain the [SOLID](https://stackify.com/solid-design-open-closed-principle/ "Solid") principles - specifically the Open-Closed Principle.  
   <b><i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;“Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.”  - Bertrand Meyer 1988</i></b>  
   This allows the application to create as many "visitors" / components that's needed without first refactoring entire code base. 
   The Visitor pattern also allowed easier data retrieval and added a way of simulating double dispatch in Java (where it isn't supported by default).  
   A [quick read on Medium.com](https://medium.com/@darrenwedgwood/visitor-pattern-and-double-dispatch-part-1-e8d83426a0e7 "quick read on Medium.com") 
   helps explains how the Visitor pattern grants the ability to use Double Dispatch.  
     
   The Strategy pattern was used when creating the GrepLogVisitor to search for various object types (GitCommit, GitFileEntry, and GitBlob)  
   * Example:  
   ```  
   public interface GrepLogFilter {  
    public boolean matchesCommit(GitCommit commit); 
    public boolean matchesFileEntry(GitFileEntry entry);
   }
   
   : commit 277b404b0fa457559b8a851d7c8214987a18b065
   Author: tim
   Note: Fixed DST bug
   
   : commit_entry 3ed1c0b5aa9989451b1c5167ce02d34629e3d0f5
   Author: corey
   Note: Added unit tests

   ```

   
