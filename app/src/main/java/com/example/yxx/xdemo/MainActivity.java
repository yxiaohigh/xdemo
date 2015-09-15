package com.example.yxx.xdemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {


    private ExpandableListView lv;
    private String[] chiledren;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ExpandableListView) findViewById(R.id.myelv);
        final Mblv mblv = new Mblv();
        lv.setGroupIndicator(null);
        lv.setAdapter(mblv);
        lv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                boolean groupExpanded = parent.isGroupExpanded(groupPosition);
                if (!groupExpanded) {//如果展开则处理点击事件
                    chiledren = new String[100];
                    for (int i = 0; i < 100; i++) {
                        chiledren[i]=1+(int)(Math.random()*50)+"";
                    }
                    Toast.makeText(getApplicationContext(),"ssss",Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

    }


    class Mblv extends BaseExpandableListAdapter {
        private String[] roomName = new String[]{"房间1", "房间2", "房间3", "房间4", "房间5","房间6",
                "房间7", "房间8", "房间9", "房间10","房间11", "房间12", "房间13", "房间14", "房间15"};

        @Override
        public int getGroupCount() {
            return roomName.length;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return chiledren.length;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return roomName[groupPosition];
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return chiledren[childPosition];
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.parents_item, null);
            }
            TextView tv = (TextView) convertView.findViewById(R.id.parent_textview);
            tv.setText(roomName[groupPosition]);
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.children_item, null);
            }
            TextView tv = (TextView) convertView.findViewById(R.id.parent_textview);
            tv.setText(chiledren[childPosition]);
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }
    }
}
