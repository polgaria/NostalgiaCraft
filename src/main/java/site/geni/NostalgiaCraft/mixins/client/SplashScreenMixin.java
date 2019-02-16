package site.geni.NostalgiaCraft.mixins.client;

import net.minecraft.class_766;
import net.minecraft.client.gui.Screen;
import net.minecraft.client.gui.SplashScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@SuppressWarnings("unused")
@Mixin(SplashScreen.class)
public abstract class SplashScreenMixin extends Screen {
	@ModifyArg(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/SplashScreen;drawRect(IIIII)V", ordinal = 0), method = "draw", index = 4)
	private int alphaBackgroundColor(int original) {
		return -13159581;
	}

	@ModifyConstant(constant = @Constant(floatValue = 1000F), method = "draw")
	private float instantFadeSpeed(float original) {
		return 0F;
	}

	@ModifyArgs(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/SplashScreen;renderProgressBar(IIIIFF)V"), method = "draw")
	private void drawLoadingBarOffScreen(Args args) {
		args.setAll(-10, -10, -10, -10, -1F, -1F);
	}

	@Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/class_766;method_3317(FF)V"), method = "draw")
	private void drawDirtBackgroundDuringFade(class_766 class_766, float float_1, float float_2) {
		this.drawBackground();
	}

	@ModifyArgs(at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/platform/GlStateManager;color4f(FFFF)V", ordinal = 1), method = "draw")
	private void fadeTransparentColor(Args args) {
		args.setAll(0F, 0F, 0F, 0F);
	}
}
