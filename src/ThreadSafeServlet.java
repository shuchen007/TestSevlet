import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadSafeServlet extends HttpServlet implements SingleThreadModel {

    public static String name = "Hello";   //静态变量，可能发生线程安全问题
    int i;  //实例变量，可能发生线程安全问题
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    public void init() throws ServletException {
        boolean bool = pingLink();
        // 取得Application对象
        ServletContext application = this.getServletContext();
        // 设置Application属性
        application.setAttribute("bool", bool);

        System.out.println(getInitParameter("param1"));
        System.out.println(getServletContext().getInitParameter("param0"));
        super.init();
        System.out.println("Servlet初始化");
    }


    public ThreadSafeServlet() {
        System.out.println("构造方法");
    }

    public boolean pingLink(){
        System.out.println("pingLInk");
        boolean bool = true;
        Runtime runtime = Runtime.getRuntime(); // 获取当前程序的运行进对象
        Process process = null; // 声明处理类对象
        String line = null; // 返回行信息
        InputStream is = null; // 输入流
        InputStreamReader isr = null; // 字节流
        BufferedReader br = null;
        String ip = "www.baidu.com";
        boolean res = false;// 结果
        try {
            process = runtime.exec("ping " + ip); // PING
            is = process.getInputStream(); // 实例化输入流
            isr = new InputStreamReader(is);// 把输入流转换成字节流
            br = new BufferedReader(isr);// 从字节中读取文本
            while ((line = br.readLine()) != null) {
                if (line.contains("TTL")) {
                    res = true;
                    break;
                }
            }
            is.close();
            isr.close();
            br.close();
            if (res) {
//             Log.print("ping www.baidu.com通...已经连接外网");
            } else {
                bool = false;
//             Log.print("ping www.baidu.com不通...无法连接外网");
            }
        } catch (IOException e) {
//            Log.print(e.getMessage());
        }
        return bool;
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
        super.destroy();
    }

    @Override
    protected synchronized void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.printf("%s：%s[%s]\n", Thread.currentThread().getName(), i, format.format(new Date()));
        i++;
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        req.getSession().setAttribute("Title","DODO1");
        System.out.printf("%s：%s[%s]\n", Thread.currentThread().getName(), i, format.format(new Date()));
        resp.getWriter().println("<html><body><h1>" + i + "</h1></body></html>");
        System.out.println("收到get"+new Date());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
        System.out.println("收到post"+new Date());
    }
}