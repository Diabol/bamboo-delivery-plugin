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
package se.diabol.bamboo.plugin.model;

import com.google.common.collect.ImmutableList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

import static com.google.common.base.Objects.toStringHelper;

@XmlRootElement
public class Pipeline extends AbstractItem {
    @XmlElement
    private List<Stage> stages;

    @XmlElement
    private String version;

    @XmlElement
    private List<UserInfo> triggeredBy;

    @XmlElement
    private boolean aggregated;

    @XmlElement
    private String timestamp;

    public Pipeline() {
        super();
    }

    public Pipeline(String name, String version, String timestamp, List<UserInfo> triggeredBy, List<Stage> stages, boolean aggregated) {
        super(name);
        this.version = version;
        this.triggeredBy = triggeredBy;
        this.aggregated = aggregated;
        this.stages = ImmutableList.copyOf(stages);
        this.timestamp = timestamp;
    }

    public List<Stage> getStages() {
        return stages;
    }

    public String getVersion() {
        return version;
    }

    @SuppressWarnings("unused")
    public String getTimestamp() {
        return timestamp;
    }

    @SuppressWarnings("unused")
    public boolean isAggregated() {
        return aggregated;
    }

    @SuppressWarnings("unused")
    public List<UserInfo> getTriggeredBy() {
        return triggeredBy;
    }

    @SuppressWarnings("unused")
    public int getId() {
        return hashCode();
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), version, stages);
    }

    @Override
    public boolean equals(Object o) {
        return o == this || o instanceof Pipeline && equals((Pipeline) o);
    }

    private boolean equals(Pipeline o) {
        return super.equals(o) && Objects.equals(stages, o.stages) && Objects.equals(version, o.version);
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("name", getName())
                .add("version", getVersion())
                .add("stages", getStages())
                .toString();
    }
}
