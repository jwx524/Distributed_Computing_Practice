
 
import wsproxy.*;
 
public class qqOnlineInfoClient{
 
    public static void main(String[] args) {
    	QqOnlineWebService service = new QqOnlineWebService();
    	QqOnlineWebServiceSoap pService = service.getQqOnlineWebServiceSoap();
         
        System.out.println(pService.qqCheckOnline(args[0]));
        System.out.println("Y = ���ߣ�N = ���ߣ�E = QQ�������A = ��ҵ�û���֤ʧ�ܣ�V = ����û���������");
        
    }
 
}