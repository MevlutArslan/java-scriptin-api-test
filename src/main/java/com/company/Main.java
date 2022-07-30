package main.java.com.company;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {

    public static void main(String[] args) throws Exception {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("graal.js");
        scriptEngine.eval("let a = 10; const b = 20; print(a*b);");
        scriptEngine.eval(new FileReader("src/main/resources/scripts/script.js"));
    }
}
