package problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class HelpDesk  implements IHelpDesk{
    final private List<IEmployee> employees;
    private List<ITicket> tickets;
    HelpDesk(){
        employees = new ArrayList<>();
        tickets = new ArrayList<>();
    }
    @Override
    public void addTicket(ITicket ticket) {

        tickets.add(ticket);


    }

    @Override
    public void addEmployee(IEmployee employee) {
        employees.add(employee);
    }

    @Override
    public void completeTicket(String employeeFullName, int ticketId) {

        IEmployee em = employees.stream().filter(e->e.getFullName().equals(employeeFullName)).findFirst().orElse(null);
        if(em==null) return;

        ITicket ticket = tickets.stream().filter(t->t.getId()==ticketId).findFirst().orElse(null);
        if(ticket==null) return;

        if(ticket.getPoint() > em.getPointLevel() || em.getAssignedCategories().stream().noneMatch(c->c==ticket.getCategory()) ) return;

        ticket.setAssignedEmployee(em.getFullName());
        ticket.setIsCompleted(true);

    }

    @Override
    public int getWaitingTicketCount() {

        return (int) tickets.stream()
                .filter(t -> !t.getIsCompleted())
                .count();

    }

    @Override
    public int getCompletedTicketsTotalPoint() {
        return tickets.stream().map(t->(t.getIsCompleted() ? t.getPoint() : 0)).reduce(0,Integer::sum);
    }

    @Override
    public List<CategoryNode> getTicketsTotalPointByCategory() {
        ArrayList<CategoryNode> categoryNodes = new ArrayList<>();

        for(Category c: Category.values()){
            int points =  tickets.stream().filter(t->t.getCategory()==c).mapToInt(ITicket::getPoint).sum();

            categoryNodes.add(new CategoryNode(c,points));


        }

        return  categoryNodes;
    }

    @Override
    public List<EmployeeNode> getTicketsTotalPointByEmployee() {
        ArrayList<EmployeeNode> employeeNodes = new ArrayList<>();

        for(IEmployee e: employees){

            int points =  tickets.stream().filter(ITicket::getIsCompleted).filter(t->e.getFullName().equals(t.getAssignedEmployee())).mapToInt(ITicket::getPoint).sum();

            employeeNodes.add(new EmployeeNode(e,points));

        }

        return  employeeNodes;
    }
}
