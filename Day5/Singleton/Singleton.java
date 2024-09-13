class Logger{
    private static Logger instance = null;
    private Logger(){

    }

    public static Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message){
        System.out.print("Log:" + message);
    }
}

public class Singleton{
    public static void main(String args[]){
        Logger logs = Logger.getInstance();
        logs.log("Application Started");
        logs.log("Application running");
        logs.log("Application Stopped");
    }
}