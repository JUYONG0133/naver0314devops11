
public class page425_7
{
    class Chat
    {
        void start() {}
        void sendMessage(String Message) {}
    }

    void startChat(String chatId)
    {
        //String nickName = null; //final 형의 특성을 가진다.
        //nickName = chatId;
        String nickName = chatId;// 그렇기 때문에 처음부터 값을 지정해준다.

        Chat chat = new Chat() //내부 클래스
        {
            @Override
            public void start()
            {
                while(true)
                {
                    String inputData = "안녕하세요";
                    String message = "[" + nickName + "] " + inputData;
                    //오류문구 : Local variable nickName defined in an enclosing scope must be final or effectively final
                    //enclosing scope 안에 선언된 지역변수 nickName은 final의 특징을 가진다.
                    sendMessage(message);
                }
            }
        };

        chat.start();
    }
}