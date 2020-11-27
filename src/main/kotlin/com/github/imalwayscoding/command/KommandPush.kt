package com.github.imalwayscoding.command

import com.github.noonmaru.kommand.KommandBuilder
import com.github.noonmaru.kommand.argument.double
import com.github.noonmaru.kommand.argument.player
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.util.Vector

object KommandPush {

    fun register(builder: KommandBuilder) {
        builder.apply {
            then("") {
                executes { it.sender.sendMessage("${ChatColor.RED}type command to execute") }
            }
            then("info") {
                executes { it.sender.sendMessage("${ChatColor.GREEN}Push Plugin by Line") }
            }
            then("player") {
                then("target" to player()) {
                    then("value" to double()) {
                        require { this is Player }
                        executes {
                            val player = it.sender as Player
                            val target: Player = it.parseArgument("target")
                            val temp: Double = it.parseArgument("value")
                            val vector = Vector(
                                player.location.direction.x,
                                player.location.direction.y,
                                player.location.direction.z
                            )
                            target.velocity = vector.multiply(temp)
                            target.sendMessage("${ChatColor.YELLOW}${player} Pushed you with value : $temp")
                            player.sendMessage("${ChatColor.YELLOW}Push Success with value : $temp")
                        }
                    }
                }
            }
            then("value" to double()) {
                require { this is Player }
                executes {
                    val player = it.sender as Player
                    val temp: Double = it.parseArgument("value")
                    val vector = Vector(
                        player.location.direction.x,
                        player.location.direction.y,
                        player.location.direction.z
                    )
                    player.velocity = vector.multiply(temp)
                    player.sendMessage("${ChatColor.YELLOW}Push Success with value : $temp")
                }
            }
        }
    }
}