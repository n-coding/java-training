package jp.co.training;

public abstract class Command {

    protected Result result;

    protected Command next;

    public Command setNext(Command next) {
        this.next = next;
        return next;
    }

    public abstract Result execute(String command, String[] argments);

}
