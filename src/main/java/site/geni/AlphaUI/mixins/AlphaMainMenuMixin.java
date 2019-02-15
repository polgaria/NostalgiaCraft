package site.geni.AlphaUI.mixins;

import net.minecraft.client.gui.MainMenuScreen;
import net.minecraft.client.gui.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("unused")
@Mixin(MainMenuScreen.class)
public class AlphaMainMenuMixin extends Screen {
	@Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/texture/TextureManager;bindTexture(Lnet/minecraft/util/Identifier;)V", ordinal = 1), method = "draw")
	private void drawDirtBackground(CallbackInfo ci) {
		this.drawBackground();
	}
}
