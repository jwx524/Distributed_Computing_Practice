
 
import wsproxy.*;
 
public class qqOnlineInfoClient{
 
    public static void main(String[] args) {
    	QqOnlineWebService service = new QqOnlineWebService();
    	QqOnlineWebServiceSoap pService = service.getQqOnlineWebServiceSoap();
         
        System.out.println(pService.qqCheckOnline(args[0]));
        System.out.println("Y = 在线；N = 离线；E = QQ号码错误；A = 商业用户验证失败；V = 免费用户超过数量");
        
    }
 
}