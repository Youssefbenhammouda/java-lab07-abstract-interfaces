package problem2;

import java.util.ArrayList;
import java.util.List;

class Employee implements IEmployee {
    private String fullName;
    private int pointLevel;
    private List<Category> assignedCategories;

    Employee(String fullName, int pointLevel, List<Category> assignedCategories) {
        this.fullName = fullName;
        this.pointLevel = pointLevel;
        this.assignedCategories = new ArrayList<>(assignedCategories);
    }

    @Override
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public void setPointLevel(int pointLevel) {
        this.pointLevel = pointLevel;
    }

    @Override
    public int getPointLevel() {
        return pointLevel;
    }

    @Override
    public void setAssignedCategories(List<Category> assignedCategories) {
        this.assignedCategories = new ArrayList<>(assignedCategories);
    }

    @Override
    public List<Category> getAssignedCategories() {
        return assignedCategories;
    }
}
