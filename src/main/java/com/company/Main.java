package main.java.com.company;

import com.company.Entity;
import org.graalvm.polyglot.Context;

import javax.script.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) throws Exception {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("graal.js");
//        // inline JavaScript execution
//        scriptEngine.eval("let a = 10; const b = 20; print(a*b);");
//
//        // execute JavaScript from a file
//        scriptEngine.eval(new FileReader("src/main/resources/scripts/script.js"));

        // pass Objects into JavaScript and let js access & modify their properties;
        Entity entity = new Entity("Player");

        Bindings bindings = scriptEngine.getBindings(ScriptContext.ENGINE_SCOPE);
        bindings.put("polyglot.js.allowHostClassLookup", (Predicate<String>) s -> true);
        bindings.put("polyglot.js.allowHostAccess", true);

        scriptEngine.put("playerEntity", entity);
        scriptEngine.eval(new FileReader("src/main/resources/scripts/variablePassing.js"));
    }
}
