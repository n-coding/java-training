package jp.co.training;

public interface Command {

    void setArgments(String[] argments);

    Result execute();

}
