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


import se.diabol.bamboo.plugin.pipeline.model.status.Status;

import javax.xml.bind.annotation.XmlElement;
import java.util.Objects;

import static com.google.common.base.Objects.toStringHelper;

public class Task extends AbstractItem {
    @XmlElement
    private String id;
    @XmlElement
    private String link;
    @XmlElement
    private TestResult testResult;
    @XmlElement
    private Status status;
    @XmlElement
    private boolean manual;
    @XmlElement
    private String buildId;

    public Task() {
    }

    public Task(String id, String name, String buildId, Status status, String link, boolean manual, TestResult testResult) {
        super(name);
        this.id = id;
        this.link = link;
        this.testResult = testResult;
        this.status = status;
        this.manual = manual;
        this.buildId = buildId;
    }

    public boolean isManual() {
        return manual;
    }

    public String getBuildId() {
        return buildId;
    }

    public String getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    @SuppressWarnings("unused")
    public TestResult getTestResult() {
        return testResult;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, super.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj instanceof Task && equals((Task) obj);
    }

    private boolean equals(Task o) {
        return Objects.equals(id, o.id) && Objects.equals(status, o.status) && super.equals(o);
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("id", getId())
                .add("name", getName())
                .add("status", getStatus())
                .toString();
    }
}
