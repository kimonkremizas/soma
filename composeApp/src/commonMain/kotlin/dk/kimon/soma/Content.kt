/*
 * Copyright 2025 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dk.kimon.soma

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.EntryProviderScope
import androidx.navigation3.runtime.NavKey

fun EntryProviderScope<NavKey>.featureASection(
    onSubRouteClick: () -> Unit,
) {
    entry<RouteA> {
        Content("Route A") {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = onSubRouteClick) {
                    Text("Go to A1")
                }
            }
        }
    }
    entry<RouteA1> {
        Content("Route A1") {
            var count by rememberSaveable {
                mutableIntStateOf(0)
            }

            Button(onClick = { count++ }) {
                Text("Value: $count")
            }
        }
    }
}

fun EntryProviderScope<NavKey>.featureBSection(
    onSubRouteClick: () -> Unit,
) {
    entry<RouteB> {
        Content("Route B") {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = { error("This is a test crash") }) {
                    Text("Go to B1")
                }
            }
        }
    }
    entry<RouteB1> {
        Content("Route B1") {
            var count by rememberSaveable {
                mutableIntStateOf(0)
            }
            Button(onClick = { count++ }) {
                Text("Value: $count")
            }
        }
    }
}

fun EntryProviderScope<NavKey>.featureCSection(
    onSubRouteClick: () -> Unit,
) {
    entry<RouteC> {
        Content("Route C") {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = onSubRouteClick) {
                    Text("Go to C1")
                }
            }
        }
    }
    entry<RouteC1> {
        Content("Route C1") {
            var count by rememberSaveable {
                mutableIntStateOf(0)
            }

            Button(onClick = { count++ }) {
                Text("Value: $count")
            }
        }
    }
}

@Composable
private fun Content(
    title: String,
    content: @Composable () -> Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title)
            content()
        }
    }
}