/**
 * This file is part of Graylog.
 *
 * Graylog is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Graylog is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Graylog.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.graylog.events.notifications;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = NotificationParameters.TYPE_FIELD,
        visible = true,
        defaultImpl = NotificationParameters.FallbackParameters.class)
public interface NotificationParameters {
    String TYPE_FIELD = "type";

    @JsonProperty(TYPE_FIELD)
    String type();

    interface Builder<SELF> {
        @JsonProperty(TYPE_FIELD)
        SELF type(String type);
    }

    class FallbackParameters implements NotificationParameters {
        @Override
        public String type() {
            return "";
        }
    }
}
