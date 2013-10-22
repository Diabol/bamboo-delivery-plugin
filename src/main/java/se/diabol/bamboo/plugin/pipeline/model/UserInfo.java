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


public class UserInfo extends AbstractItem {

    private String avatarUrl;
    private String url;

    public UserInfo() {
        super();
    }


    public UserInfo(String name) {
        this(name, null, null);
    }

    public UserInfo(String name, String url, String avatarUrl) {
        super(name);
        this.avatarUrl = avatarUrl;
        this.url = url;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getUrl() {
        return url;
    }
}
