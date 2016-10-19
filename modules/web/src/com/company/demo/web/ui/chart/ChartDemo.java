package com.company.demo.web.ui.chart;

import com.haulmont.bali.util.ParamsMap;
import com.haulmont.charts.gui.amcharts.model.data.ListDataProvider;
import com.haulmont.charts.gui.amcharts.model.data.MapDataItem;
import com.haulmont.charts.gui.components.charts.Chart;
import com.haulmont.cuba.gui.components.AbstractWindow;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChartDemo extends AbstractWindow {
    @Inject
    private Chart ganttChart;

    @Override
    public void init(Map<String, Object> params) {
        ListDataProvider dataProvider = new ListDataProvider();

        List<MapDataItem> segments = new ArrayList<>();
        segments.add(new MapDataItem(ParamsMap.of("start", "2016-01-01",
                "end", "2016-01-14", "task", "Gathering requirements", "color", "#b9783f")));
        segments.add(new MapDataItem(ParamsMap.of("start", "2016-01-16",
                "end", "2016-01-27", "task", "Producing specifications")));
        segments.add(new MapDataItem(ParamsMap.of("start", "2016-02-05",
                "end", "2016-04-18", "task", "Development")));
        segments.add(new MapDataItem(ParamsMap.of("start", "2016-04-18",
                "end", "2016-04-30", "task", "Testing and QA")));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("category", "Module #1", "segments", segments)));

        segments = new ArrayList<>();
        segments.add(new MapDataItem(ParamsMap.of("start", "2016-01-01",
                "end", "2016-01-10", "task", "Gathering requirements", "color", "#cc4748")));
        segments.add(new MapDataItem(ParamsMap.of("start", "2016-01-12",
                "end", "2016-01-15", "task", "Producing specifications")));
        segments.add(new MapDataItem(ParamsMap.of("start", "2016-01-16",
                "end", "2016-02-05", "task", "Development")));
        segments.add(new MapDataItem(ParamsMap.of("start", "2016-02-10",
                "end", "2016-02-18", "task", "Testing and QA")));
        dataProvider.addItem(new MapDataItem(ParamsMap.of("category", "Module #2", "segments", segments)));

        ganttChart.getConfiguration().setDataProvider(dataProvider);
    }
}