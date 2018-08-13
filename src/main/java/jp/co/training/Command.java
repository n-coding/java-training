package jp.co.training;

import java.util.List;

public interface Command {

    void setArgments(List<String> argments);

    void execute();

    Result validate();
}
