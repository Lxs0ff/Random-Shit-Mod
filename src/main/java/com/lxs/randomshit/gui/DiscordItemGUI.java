package com.lxs.randomshit.gui;

import com.lxs.randomshit.RandomShit;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;

public class DiscordItemGUI extends Screen {
    private static final ResourceLocation IMAGE_LOCATION = new ResourceLocation("randomshit", "textures/gui/discorditemgui.png");

    public DiscordItemGUI() {
        super(new StringTextComponent(""));
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        Minecraft.getInstance().getTextureManager().bindTexture(IMAGE_LOCATION);
        blit(matrixStack, (this.width - 224) / 2, (this.height - 224) / 2, 0, 0, 256, 256, 256, 256);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }
}
