package org.zalando.logbook;

/*
 * #%L
 * Logbook: API
 * %%
 * Copyright (C) 2015 - 2016 Zalando SE
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

public final class BaseHttpMessageTest {

    @Test
    public void shouldUseCaseInsensitiveHeaders() {
        final Map<String, List<String>> headers = new BaseHttpMessage.HeadersBuilder()
            .put("X-Secret", "s3cr3t")
            .put("X-Secret", "knowledge")
            .put("Y-Secret", Arrays.asList("one", "two"))
            .build();

        assertThat(headers.get("x-secret"), hasItem("s3cr3t"));
        assertThat(headers.get("x-secret"), hasItem("knowledge"));
        assertThat(headers.get("Y-SECRET"), hasItem("one"));
        assertThat(headers.get("Y-SECRET"), hasItem("two"));
    }
}
