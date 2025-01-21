import cn.hutool.extra.mail.MailUtil;
import org.junit.Test;

/**
 * program: saas
 * ClassName test
 * description:
 * author: xhonell
 * create: 2025年01月21日21时04分
 * Version 1.0
 **/
public class test {
    @Test
    public void test() {
        String htmlContent = "<html>"
                + "<head>"
                + "<style>"
                + "body { font-family: Arial, sans-serif; background-color: #f4f4f9; color: #333; margin: 20px; }"
                + "h2 { color: #4CAF50; }"
                + "p { font-size: 16px; line-height: 1.6; }"
                + ".highlight { color: #FF5722; font-weight: bold; }"
                + ".footer { margin-top: 30px; font-size: 12px; color: #888; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<h2>段林宏，</h2>"
                + "<p>你回去后记得 <span class='highlight'>把作业完成了</span>，然后每天晚上给我汇报哈！</p>"
                + "<p>祝你学习愉快！</p>"
                + "<div class='footer'>如果有任何问题，请随时联系我。</div>"
                + "</body>"
                + "</html>";

        MailUtil.send("549847214@qq.com", "张晓东", htmlContent, true);

    }
}
