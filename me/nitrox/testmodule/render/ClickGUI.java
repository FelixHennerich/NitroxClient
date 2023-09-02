package me.nitrox.testmodule.render;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import me.nitrox.main.NitroxClient;
import me.nitrox.testmodule.Category;
import me.nitrox.testmodule.Module;
import me.nitrox.testmodule.settings.Setting;

public class ClickGUI extends Module {
    public ClickGUI() {
        super("ClickGUI", Keyboard.KEY_RSHIFT, Category.RENDER);
    }

    @Override
    public void setup() {
        ArrayList<String> options = new ArrayList<>();
        options.add("New");
        options.add("JellyLike");
        NitroxClient.instance.settingsManager.rSetting(new Setting("Design", this, "New", options));
        NitroxClient.instance.settingsManager.rSetting(new Setting("Sound", this, false));
        NitroxClient.instance.settingsManager.rSetting(new Setting("GuiRed", this, 255, 0, 255, true));
        NitroxClient.instance.settingsManager.rSetting(new Setting("GuiGreen", this, 26, 0, 255, true));
        NitroxClient.instance.settingsManager.rSetting(new Setting("GuiBlue", this, 42, 0, 255, true));
    }

    @Override
    public void onEnable() {
        super.onEnable();

        mc.displayGuiScreen(NitroxClient.instance.clickGui);
        toggle();
    }
}
