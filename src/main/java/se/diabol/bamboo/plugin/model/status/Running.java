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
package se.diabol.bamboo.plugin.model.status;


import javax.xml.bind.annotation.XmlElement;

public class Running extends Status
{
    @XmlElement
    private final int percentage;

    Running(int percentage, long lastActivity, long duration)
    {
        super(StatusType.RUNNING, lastActivity, duration);
        this.percentage = percentage;
    }

    @SuppressWarnings("unused")
    public int getPercentage() { return percentage; }

    @Override
    public boolean isRunning() { return true; }

    @Override
    public String toString()
    {
        return "RUNNING " + percentage + "%";
    }

    @Override
    public boolean equals(Object o)
    {
        return this == o || o instanceof Running && percentage == ((Running) o).percentage;
    }

    @Override
    public int hashCode()
    {
        return percentage;
    }
}
