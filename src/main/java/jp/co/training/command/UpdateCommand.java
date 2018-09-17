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
    public CommandResult executeCommand(String command, String argments) {
        CommandResult commandResult = new CommandResult(UPDATE);

        //argmentsを解析

        //更新対象として指定しているID取得
        if (argments.indexOf(" ") == -1) {
            //TODO 構文エラーを返却
        }
        String targetId = argments.substring(0, argments.indexOf(" "));
        argments = argments.substring(argments.indexOf(" "));
        if (!targetId.equals("")) {//TODO正規表現比較に修正
            //TODO ID不正エラー
        }

        //サブコマンド(「SET」)取得
        String subCommand = argments.substring(0, argments.indexOf(" ")).toLowerCase();
        argments = argments.substring(argments.indexOf(" "));
        if (!subCommand.equals(Const.SET)) {
            //TODO エラー返却
        }

        //Bookオブジェクト生成(&バリデート)
        String[] params = argments.split(",");
        if (params.equals("")) {//TODO key=valueの形式チェック
            //TODO 構文エラー
        }

        //更新項目mapを生成
        Map<String, String> updateParams = new HashMap<>();
        for (String param : params) {
            updateParams.put(param.substring(0, param.indexOf("=")), param.substring(param.indexOf("=") + 1));
        }

        //更新実行
        DaoResult daoResult = new BookDao().update(targetId, updateParams);
        commandResult.addCodes(daoResult.getCodes());
        commandResult.setStatus(Status.OK);
        return commandResult;

    }

}
