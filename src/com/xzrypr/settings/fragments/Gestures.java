/*
 * Copyright (C) 2019-2021 The ConquerOS Project
 * Copyright (C) 2021 xdroid, xyzprjkt
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.xzrypr.settings.fragments;

import android.os.Bundle;
import android.content.Context;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

import com.android.internal.util.xdroid.Utils;
import androidx.preference.*;
import com.android.internal.logging.nano.MetricsProto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Gestures extends SettingsPreferenceFragment {

    private static final String NAVIGATION_BAR_INVERSE = "navbar_inverse_layout";

    private SwitchPreference mSwapNavButtons;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.xzrypr_settings_gestures);

        final PreferenceScreen prefScreen = getPreferenceScreen();
        mSwapNavButtons = (SwitchPreference) findPreference(NAVIGATION_BAR_INVERSE);

        if (!Utils.isThemeEnabled("com.android.internal.systemui.navbar.threebutton")) {
            prefScreen.removePreference(mSwapNavButtons);
        }
    }
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        return false;
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.XD_ZONE;
    }
}
