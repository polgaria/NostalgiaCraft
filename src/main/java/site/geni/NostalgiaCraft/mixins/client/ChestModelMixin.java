package site.geni.NostalgiaCraft.mixins.client;

import net.minecraft.client.render.entity.model.ChestEntityModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@SuppressWarnings("unused")
@Mixin(ChestEntityModel.class)
public abstract class ChestModelMixin {
	@ModifyArg(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/model/Cuboid;render(F)V", ordinal = 1), method = "method_2799")
	private float removeHatch(float a) {
		return 0F;
	}
}
