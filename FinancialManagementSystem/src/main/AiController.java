package main;

import com.baidubce.appbuilder.console.appbuilderclient.AppBuilderClient;
import com.baidubce.appbuilder.model.appbuilderclient.AppBuilderClientIterator;
import com.baidubce.appbuilder.model.appbuilderclient.AppBuilderClientResult;



public class AiController {

    public static void main(String[] args) throws Exception {
        getAiAnswer("String question");
    }

    public static String getAiAnswer(String question) throws Exception {
        // 设置环境中的TOKEN，以下TOKEN请替换为您的个人TOKEN，个人TOKEN可通过该页面【获取鉴权参数】或控制台页【密钥管理】处获取
        System.setProperty("APPBUILDER_TOKEN", "bce-v3/ALTAK-hjjQBKDaSAoMzGUPvfaVB/0e36bc6e95c1e289e809ee1af85c86812d218b43");
        // 从AppBuilder控制台【个人空间】-【应用】网页获取已发布应用的ID
        String appId = "8c9c0cd0-df9d-41ce-9da7-5d80b6df140d";
        AppBuilderClient builder = new AppBuilderClient(appId);
        String conversationId = builder.createConversation();

        AppBuilderClientIterator itor = builder.run(question, conversationId, new String[]{}, false);
        StringBuilder answer = new StringBuilder();
        while (itor.hasNext()) {
            AppBuilderClientResult response = itor.next();
            answer.append(response.getAnswer());
        }
        System.out.println(answer);

        return answer.toString();
    }



}
