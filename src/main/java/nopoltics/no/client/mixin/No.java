package nopoltics.no.client.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.advancement.AdvancementsScreen;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class No {
    @Inject(at = @At("HEAD"), method = "openScreen(Lnet/minecraft/client/gui/screen/Screen;)V", cancellable = true)
    private void no(@Nullable Screen screen, CallbackInfo ci) {
        if (screen == null) return;
        if (screen.getClass().getPackage().getName().contains("vazkii") &&
                !(screen.getClass().getPackage().getName().contains("book")) && !(screen instanceof AdvancementsScreen)) {
            ci.cancel();
        }
    }
}
