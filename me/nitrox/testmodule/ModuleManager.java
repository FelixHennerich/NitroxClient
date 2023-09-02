package me.nitrox.testmodule;

import java.util.ArrayList;

import me.nitrox.testmodule.combat.AutoArmor;
import me.nitrox.testmodule.combat.KillAura;
import me.nitrox.testmodule.player.NoFall;
import me.nitrox.testmodule.render.ClickGUI;

public class ModuleManager {
    private ArrayList<Module> modules = new ArrayList<Module>();

    public ModuleManager() {
        // COMBAT
        modules.add(new KillAura());
        //modules.add(new AntiBot());
        modules.add(new AutoArmor());
       // modules.add(new Criticals());

        // MOVEMENT
        //modules.add(new Sprint());
        //modules.add(new Fly());
        //modules.add(new Step());
       // modules.add(new LongJump());
        //modules.add(new Speed());
       // modules.add(new Phase());

        // RENDER
        modules.add(new ClickGUI());

        // PLAYER
        modules.add(new NoFall());

        // MISC

        // NONE
    }

    public ArrayList<Module> getModules() {
        return modules;
    }
    public Module getModuleByName(String name) {
        return modules.stream().filter(module -> module.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
