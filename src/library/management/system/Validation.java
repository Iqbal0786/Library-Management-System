
package library.management.system;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Validation {
    // Validation for Sign up form
    private Pattern  userID; 
    private Pattern name;
    private Pattern answer;
    private Pattern password;
    private Matcher matcher;
    
    private static final String NamePattern="^[ A-Za-z]{3,25}$";           
   
    private static final String AnswerPattern="^[ A-Za-z]{5,50}$";
    private static final String PasswordPattern="^[ A-Za-z0-9@#$]{8,16}$";
    private static final String UserIdPattern="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z-]+(\\.[A-Za-z]+)*(\\.[A-Za-z]{2,3})$";
    
    //Validation for Add Book frame
    private  Pattern bookId;
    private Pattern bookName;
    private Pattern publisher;
    private  Pattern edition;
    private Pattern price;
    private Pattern pageNO;
    
    private static final String BookId="^[0-9]{1,9}";
    private static final String Price="^[0-9]{1,9}";
    private static final String Edition="^[0-9]{1,9}";
    private static final String PageNO="^[0-9]{1,9}";
    private static final String Publisher="^[A-Za-z ]{5,50}";
    private static final String BookName="^[A-Za-z ]{5,50}";
    //Validation for Add Student
    private  Pattern studentId;
    private Pattern studentName;
     private Pattern fatherName;
     
     private static final String StudentId="^[0-9]{1,9}";
    private static final String StudentName="^[A-Za-z ]{5,50}";
    private static final String FatherName="^[A-Za-z ]{5,50}";
    
    public Validation(){
               //Matching Pattern for SignUp Frame
               name= Pattern.compile(NamePattern);
               answer=Pattern.compile(AnswerPattern);
               password= Pattern.compile(PasswordPattern);
               userID= Pattern.compile(UserIdPattern);
               
               //Matching Pattern for AddBook Frame
               bookId=Pattern.compile(BookId);
               price=Pattern.compile(Price);
               pageNO=Pattern.compile(PageNO);
               edition=Pattern.compile(Edition);
               bookName=Pattern.compile(BookName);
               publisher=Pattern.compile(Publisher);
               
               // Matching Pattern for Add Student
               studentId= Pattern.compile(StudentId);
               studentName=Pattern.compile(StudentName);
               fatherName= Pattern.compile(FatherName);
               
               
               
                  }
       // Method for SignUP Frame
      public boolean nameValidate(final String name1){
     
        matcher= name.matcher(name1);
        return matcher.matches();
 
             }
      public boolean AnswerValidate(final String answer1){
       matcher=answer.matcher(answer1);
       return matcher.matches();
      
      }
      
      
      public boolean userIdValidate(final String userId1){
      
      matcher= userID.matcher(userId1);
      return matcher.matches();
      
      }
     
      public boolean passwordValidate(final String password1){
      matcher= password.matcher(password1);
      return matcher.matches();
      
      }
      //Method For AddBook Frame
      
     public boolean bookIdvalidate(final String bookId1){
         matcher=bookId.matcher(bookId1);
         return matcher.matches();
     
          }
     public boolean bookNamevalidate(final String bookName1){
         matcher=bookName.matcher(bookName1);
         return matcher.matches();
     
          }
     public boolean PriceValidate(final String price1){
         matcher=price.matcher(price1);
         return matcher.matches();
     
          }
      public boolean PageNOValidate(final String totalpages1){
         matcher=pageNO.matcher(totalpages1);
         return matcher.matches();
     
          }
      public boolean EditionValidate(final String edition1){
         matcher=edition.matcher(edition1);
         return matcher.matches();
     
          }
      public boolean PublisherValidate(final String publisher1){
         matcher=publisher.matcher(publisher1);
         return matcher.matches();
     
          }
      // methods for add student Frame
       public boolean StudentIdValidate(final String studentID1){
         matcher=studentId.matcher(studentID1);
         return matcher.matches();
     
          }
        public boolean StudentNameValidate(final String studentName1){
         matcher=studentName.matcher(studentName1);
         return matcher.matches();
     
          }
         public boolean FatherNameValidate(final String fatherName1){
         matcher=fatherName.matcher(fatherName1);
         return matcher.matches();
     
          }
}