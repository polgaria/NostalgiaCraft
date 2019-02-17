package site.geni.NostalgiaCraft.mixins.client;

import net.minecraft.class_766;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.MainMenuScreen;
import net.minecraft.client.gui.Screen;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@SuppressWarnings("unused")
@Mixin(MainMenuScreen.class)
public abstract class MainMenuMixin extends Screen {
	/* thanks to JamiesWhiteShirt's developer-mode */
	@Mutable
	@Shadow
	@Final
	private long field_17773;
	@Mutable
	@Shadow
	@Final
	private long field_17772;

	@Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/texture/TextureManager;bindTexture(Lnet/minecraft/util/Identifier;)V", ordinal = 1), method = "draw")
	private void drawDirtBackgroundInMainMenu(CallbackInfo ci) {
		this.drawBackground();
	}

	@ModifyArg(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/MainMenuScreen;drawString(Lnet/minecraft/client/font/TextRenderer;Ljava/lang/String;III)V", ordinal = 0), method = "draw", index = 3)
	private int versionTextPosition(int original) {
		return 2;
	}

	@ModifyArg(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/MainMenuScreen;drawString(Lnet/minecraft/client/font/TextRenderer;Ljava/lang/String;III)V", ordinal = 0), method = "draw", index = 4)
	private int versionTextColor(int original) {
		return 5263440;
	}

	@Inject(at = @At("RETURN"), method = "<init>(Lnet/minecraft/class_766;J)V")
	private void constructor(class_766 class_766_1, long long_1, CallbackInfo ci) {
		field_17773 = field_17772;
	}
}
