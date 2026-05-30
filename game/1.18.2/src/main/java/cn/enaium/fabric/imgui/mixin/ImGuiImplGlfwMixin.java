package cn.enaium.fabric.imgui.mixin;

import imgui.glfw.ImGuiImplGlfw;
import org.lwjgl.system.MemoryUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.nio.IntBuffer;

/**
 * @author Enaium
 */
@Mixin(ImGuiImplGlfw.class)
public class ImGuiImplGlfwMixin {
    @Redirect(method = "initImpl", at = @At(value = "INVOKE", target = "Lorg/lwjgl/system/MemoryUtil;memAllocInt(I)Ljava/nio/IntBuffer;"))
    public IntBuffer memAllocInt(int size) {
        return MemoryUtil.memAllocInt(size);
    }

    @Redirect(method = "initImpl", at = @At(value = "INVOKE", target = "Lorg/lwjgl/system/MemoryUtil;memFree(Ljava/nio/IntBuffer;)V"))
    public void memFree(IntBuffer intBuffer) {
        MemoryUtil.memFree(intBuffer);
    }
}
