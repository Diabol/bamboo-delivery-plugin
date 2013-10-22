/*
This file is part of Delivery Pipeline Plugin.

Delivery Pipeline Plugin is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Delivery Pipeline Plugin is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Delivery Pipeline Plugin.
If not, see <http://www.gnu.org/licenses/>.
*/
package se.diabol.bamboo.plugin.pipeline.model.status;


import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

import static se.diabol.bamboo.plugin.pipeline.model.status.StatusType.*;

public class Status {

    @XmlElement
    private StatusType type;
    @XmlElement
    private long lastActivity;
    @XmlElement
    private long duration;

    public Status() {
    }

    public Status(StatusType type, long lastActivity, long duration) {
        this.type = type;
        this.lastActivity = lastActivity;
        this.duration = duration;
    }

    public StatusType getType() {
        return type;
    }

    public long getLastActivity() {
        return lastActivity;
    }

    @SuppressWarnings("unused")
    public String getTimestamp() {
        return null;
    }

    public long getDuration() {
        return duration;
    }

    public boolean isIdle() {
        return IDLE.equals(type);
    }

    public boolean isQueued() {
        return QUEUED.equals(type);
    }

    public boolean isRunning() {
        return RUNNING.equals(type);
    }

    public boolean isSuccess() {
        return SUCCESS.equals(type);
    }

    public boolean isFailed() {
        return FAILED.equals(type);
    }

    public boolean isUnstable() {
        return UNSTABLE.equals(type);
    }

    public boolean isCancelled() {
        return CANCELLED.equals(type);
    }

    public boolean isDisabled() {
        return DISABLED.equals(type);
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj instanceof Status && Objects.equals(((Status) obj).type, type);
    }

    @Override
    public String toString() {
        return String.valueOf(type);
    }
}
