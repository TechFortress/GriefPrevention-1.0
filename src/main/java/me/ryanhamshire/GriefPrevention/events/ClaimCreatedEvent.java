package me.ryanhamshire.GriefPrevention.events;

import me.ryanhamshire.GriefPrevention.Claim;
import me.ryanhamshire.GriefPrevention.Messages;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * This Event is thrown when a claim is created but before it is saved. If it is cancelled the claim will not be saved
 * however the player will not recieved information as to why it was cancelled.
 * <p>
 * Created by Narimm on 5/08/2018.
 */

public class ClaimCreatedEvent extends Event implements Cancellable
{

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlerList()
    {
        return handlers;
    }

    private final Claim claim;

    private final CommandSender creator;

    private boolean cancelled = false;

    private String cancelMessage = null;

    public ClaimCreatedEvent(Claim claim, CommandSender creator)
    {
        this.claim = claim;
        this.creator = creator;
    }

    @Override
    public HandlerList getHandlers()
    {
        return handlers;
    }

    @Override
    public boolean isCancelled()
    {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b)
    {
        this.cancelled = b;
    }

    /**
     * Get a message for cancellation optionally provided by an event handler
     *
     * @return String
     */
    public String getCancelMessage()
    {
        return cancelMessage;
    }

    /**
     * @param cancelMessage A message optionally specified when cancelling this event
     */
    public void setCancelMessage(String cancelMessage)
    {
        this.cancelMessage = cancelMessage;
    }

    /**
     * The Claim
     *
     * @return Claim
     */
    public Claim getClaim()
    {
        return claim;
    }

    /**
     * The actor creating the claim
     *
     * @return the CommandSender
     */
    public CommandSender getCreator()
    {
        return creator;
    }
}
