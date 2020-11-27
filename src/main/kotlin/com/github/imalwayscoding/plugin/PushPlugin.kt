package com.github.imalwayscoding.plugin

import com.github.imalwayscoding.command.KommandPush
import com.github.noonmaru.kommand.kommand
import org.bukkit.plugin.java.JavaPlugin

class PushPlugin : JavaPlugin() {

    override
    fun onEnable() {
        server.consoleSender.sendMessage("[Push(Kotlin)] Plugin Enabled.")
        server.consoleSender.sendMessage("[Push(Kotlin)] Command Loading..")
        register()
        server.consoleSender.sendMessage("[Push(Kotlin)] Command Loaded Successfully.")
    }

    override
    fun onDisable() {
        server.consoleSender.sendMessage("[Push(Kotlin)] Plugin Disabled.")
    }

    fun register() {
        kommand {
            register("p") {
                KommandPush.register(this)
            }
            register("push") {
                KommandPush.register(this)
            }
        }
    }

}