package problem2;

class Ticket implements ITicket {
    private int id;
    private String name;
    private Category category;
    private int point;
    private String assignedEmployee;
    private boolean isCompleted;

    Ticket(int id, String name, Category category, int point) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.point = point;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public int getPoint() {
        return point;
    }

    @Override
    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    @Override
    public boolean getIsCompleted() {
        return isCompleted;
    }

    @Override
    public void setAssignedEmployee(String assignedEmployee) {
        this.assignedEmployee = assignedEmployee;
    }

    @Override
    public String getAssignedEmployee() {
        return assignedEmployee;
    }
}
