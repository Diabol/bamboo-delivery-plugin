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
package se.diabol.bamboo.plugin.pipeline.model;

import com.google.common.collect.ImmutableList;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import java.util.Objects;

import static com.google.common.base.Objects.toStringHelper;

public class Stage extends AbstractItem
{
    @XmlElement
    private List<Task> tasks;

    @XmlElement
    private String version;

    public Stage() {
    }

    public Stage(String name, List<Task> tasks, String version)
    {
        super(name);
        this.tasks = tasks;
        this.version = version;
    }

    public Stage(String name, List<Task> tasks)
    {
        super(name);
        this.tasks = ImmutableList.copyOf(tasks);
    }

    public List<Task> getTasks()
    {
        return tasks;
    }

    public String getVersion() {
        return version;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(tasks);
    }

    @Override
    public boolean equals(Object o)
    {
        return o == this || o instanceof Stage && equals((Stage) o);
    }

    private boolean equals(Stage o)
    {
        return Objects.equals(tasks, o.tasks) && Objects.equals(version, o.version) && super.equals(o) ;
    }

    @Override
    public String toString()
    {
        return toStringHelper(this)
                .add("name", getName())
                .add("version", getVersion())
                .add("tasks", getTasks())
                .toString();
    }
}
