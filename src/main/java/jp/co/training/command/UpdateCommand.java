package jp.co.training.command;

import static jp.co.training.Const.*;

import java.util.HashMap;
import java.util.Map;

import jp.co.training.Const;

import jp.co.training.common.Status;
import jp.co.training.dao.BookDao;
import jp.co.training.dao.DaoResult;

public class UpdateCommand extends Command {

    public UpdateCommand(String name) {
        super(name);
    }

    @Override
    public CommandResult executeCommand(String argments) {
        CommandResult commandResult = new CommandResult(UPDATE);

        //argmentsを解析
        String[] params = argments.split(" " + Const.SET + " ");
        if (params.length == 1) {
            //TODO 構文エラーを返却
        }

        String targetId = params[0];
        String[] keyValues = params[1].split(",");

        //更新項目mapを生成
        Map<String, String> updateParams = new HashMap<>();
        for (String keyValue : keyValues) {
            //TODO正規表現でkey=valueの形式チェック
            updateParams.put(keyValue.substring(0, keyValue.indexOf("=")),
                    keyValue.substring(keyValue.indexOf("=") + 1));
        }

        //更新実行
        DaoResult daoResult = new BookDao().update(targetId, updateParams);
        commandResult.addCodes(daoResult.getCodes());
        commandResult.setStatus(Status.OK);
        return commandResult;

    }

}
