/*
 * Copyright (C) 2016 The Android Open Source Project
 *
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
 */
package com.example.unknown.cheaper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.unknown.cheaper.Clases.NavItemsClass;

import java.util.ArrayList;


public class NavigationItemsAdapter extends ArrayAdapter<NavItemsClass> {
    private int backgrouncolor;


    public NavigationItemsAdapter(Context context, ArrayList<NavItemsClass> items) {
        super(context, 0, items);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.special_navigation_item, parent, false);
        }
        NavItemsClass currentitem = getItem(position);
        TextView name = (TextView) listItemView.findViewById(R.id.txt_navitem);
        ImageView imageView =(ImageView)listItemView.findViewById(R.id.img_navitem);
        imageView.setImageResource(currentitem.getImg());
        name.setText(currentitem.getName());

            return listItemView;
        }
    }
