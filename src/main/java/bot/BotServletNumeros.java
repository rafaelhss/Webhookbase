package bot;

import bot.estados.Estado;
import bot.estados.EstadoInicial;
import bot.model.Update;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class BotServletNumeros extends HttpServlet {

        public HashMap<Integer, Estado> estados = new HashMap<Integer, Estado>();
    
    
  public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("text/html;charset=UTF-8");
      System.out.println("oieee");
    try (PrintWriter out = resp.getWriter()) {
        out.println("<h1>Bot Servlet Numeros ao seu dispor!!!</h1>");
        StringBuffer jb = new StringBuffer();
        String line = null;
        BufferedReader reader = req.getReader();
        while ((line = reader.readLine()) != null) {
              jb.append(line);
         }
         Gson gson = new GsonBuilder()
                  .registerTypeAdapter(Update.class, new bot.parser.TelegramUpdateDeserializer())
                   .create();
        Update c = gson.fromJson(jb.toString(), Update.class);
        
        
        
        Estado e = estados.get(c.getMessage().getFrom().id);
        if (e == null){
            e = new EstadoInicial();
        }
        e.processaTexto(c.getMessage().getText());
        
        estados.put(c.getMessage().getFrom().id, e.getProximoEstado());
        
        new bot.sender.Sender("225779469:AAEB6m12LCsREqUgCSU0lt9WtRUPopEVZY8").sendResponse(c.getMessage().getFrom().getId(), e.getMensagemResposta());
    }
  }

  
  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      processRequest(req, resp); 
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      processRequest(req, resp); 
  }
}
