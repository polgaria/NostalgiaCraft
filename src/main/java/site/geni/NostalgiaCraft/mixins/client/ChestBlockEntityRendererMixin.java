package site.geni.NostalgiaCraft.mixins.client;

import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@SuppressWarnings("unused")
@Mixin(ChestBlockEntityRenderer.class)
public abstract class ChestBlockEntityRendererMixin {
	@ModifyConstant(constant = @Constant(floatValue = 1.5707964F), method = "method_3561")
	private float removeLidAnimation(float orig) {
		return 0F;
	}
}
