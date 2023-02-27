package id.kawahedukasi.tugas4;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class NomorTiga {
    public static void main(String[] args) {
//      a.
        LinkedHashMap<String, Object> shyam = new LinkedHashMap<>();
        shyam.put("nama", "Shyam");
        shyam.put("email", "shyamjaiswal@gmail.com");

        LinkedHashMap<String, Object> bob = new LinkedHashMap<>();
        bob.put("nama", "Bob");
        bob.put("email", "bob32@gmail.com");

        LinkedHashMap<String, Object> jai = new LinkedHashMap<>();
        jai.put("nama", "Jai");
        jai.put("email", "jai87@gmail.com");

        List<Object> employees = new ArrayList<>();
        employees.add(shyam);
        employees.add(bob);
        employees.add(jai);

        LinkedHashMap<String, Object> a = new LinkedHashMap<>();
        a.put("employees", employees);

        System.out.println(a);

//      b.
        LinkedHashMap<String, Object> newMenu = new LinkedHashMap<>();
        newMenu.put("value", "New");
        newMenu.put("onclick", "CreateDoc()");

        LinkedHashMap<String, Object> openMenu = new LinkedHashMap<>();
        openMenu.put("value", "Open");
        openMenu.put("onclick", "OpenDoc()");

        LinkedHashMap<String, Object> saveMenu = new LinkedHashMap<>();
        saveMenu.put("value", "Save");
        saveMenu.put("onclick", "SaveDoc()");

        List<Object> menuItem = new ArrayList<>();
        menuItem.add(newMenu);
        menuItem.add(openMenu);
        menuItem.add(saveMenu);

        LinkedHashMap<String, Object> popup = new LinkedHashMap<>();
        popup.put("menuitem", menuItem);

        LinkedHashMap<String, Object> menu = new LinkedHashMap<>();
        menu.put("id", "file");
        menu.put("value", "File");
        menu.put("popup", popup);

        LinkedHashMap<String, Object> b = new LinkedHashMap<>();
        b.put("menu", menu);

        System.out.println(b);

//      c.
        LinkedHashMap<String, Object> window = new LinkedHashMap<>();
        window.put("title", "Sample Konfabulator Widget");
        window.put("name", "main_window");
        window.put("width", 500);
        window.put("height", 500);

        LinkedHashMap<String, Object> image = new LinkedHashMap<>();
        image.put("src", "Images/Sun.png");
        image.put("name", "sun1");
        image.put("hOffset", 250);
        image.put("vOffset", 250);
        image.put("alignment", "center");

        LinkedHashMap<String, Object> text = new LinkedHashMap<>();
        text.put("data", "Click Here");
        text.put("size", 36);
        text.put("style", "bold");
        text.put("name", "text1");
        text.put("hOffset", 250);
        text.put("vOffset", 100);
        text.put("alignment", "center");
        text.put("onMouseUp", "sun1.opacity = (sun1.opacity / 100) * 90;");

        LinkedHashMap<String, Object> widget = new LinkedHashMap<>();
        widget.put("debug", "on");
        widget.put("window", window);
        widget.put("image", image);
        widget.put("text", text);

        LinkedHashMap<String, Object> c = new LinkedHashMap<>();
        c.put("widget", widget);

        System.out.println(c);
    }
}