package model.rec;

public class EducationManagerVO {
   String name, startDate, endDate, content, target, location;
   int eb_num,participants;

   public EducationManagerVO() {
   }

   // name, startdate,enddate,content,location,target,participants
   public EducationManagerVO(String name, String startDate, String endDate, String content, String location,
         String target, int participants) {
      this.name = name;
      this.startDate = startDate;
      this.endDate = endDate;
      this.content = content;
      this.location = location;
      this.target = target;
      this.participants = participants;

      
      
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getStartDate() {
      return startDate;
   }

   public void setStartDate(String startDate) {
      this.startDate = startDate;
   }

   public String getEndDate() {
      return endDate;
   }

   public void setEndDate(String endDate) {
      this.endDate = endDate;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public String getTarget() {
      return target;
   }

   public void setTarget(String target) {
      this.target = target;
   }

   public String getLocation() {
      return location;
   }

   public void setLocation(String location) {
      this.location = location;
   }

   public int geteb_num() {
      return eb_num;
   }
   
   public void seteb_num(int seteb_num) {
      this.eb_num = seteb_num;
   }

   
   public int getParticipants() {
      return participants;
   }

   public void setParticipants(int participants) {
      this.participants = participants;
   }
}
