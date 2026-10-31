package problem2;

import java.io.*;
import java.util.*;

class CategoryNode {
    Category category;
    int totalPoint;
    CategoryNode(Category category, int totalPoint){
        this.category = category;
        this.totalPoint = totalPoint;
    }
}

class EmployeeNode {
    IEmployee employee;
    int totalPoint;
    EmployeeNode(IEmployee employee, int totalPoint){
        this.employee = employee;
        this.totalPoint = totalPoint;
    }
}

enum Category {
    InformationTechnologies,
    HumanResources,
    Accounting,
    Sales,
    Marketing,
    Legal
}

interface IEmployee {
    public void setFullName(String fullName);
    public String getFullName();
    public void setPointLevel(int pointLevel);
    public int getPointLevel();
    public void setAssignedCategories(List <Category> assignedCategories);
    public List <Category> getAssignedCategories();
}

interface ITicket {
    public void setId(int id);
    public int getId();
    public void setName(String name);
    public String getName();
    public void setCategory(Category category);
    public Category getCategory();
    public void setPoint(int point);
    public int getPoint();
    public void setIsCompleted(boolean isCompleted);
    public boolean getIsCompleted();
    public void setAssignedEmployee(String assignedEmployee);
    public String getAssignedEmployee();
}

interface IHelpDesk {
    public void addTicket(ITicket ticket);
    public void addEmployee(IEmployee employee);
    public void completeTicket(String employeeFullName, int ticketId);
    public int getWaitingTicketCount();
    public int getCompletedTicketsTotalPoint();
    public List <CategoryNode> getTicketsTotalPointByCategory();
    public List <EmployeeNode> getTicketsTotalPointByEmployee();
}