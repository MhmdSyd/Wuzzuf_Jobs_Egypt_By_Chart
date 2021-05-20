import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.DateColumn;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.selection.Selection;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.util.Map;


public class TableSaw {
    public Table createTable(Map testMap,String str){
        //create two column table.
        Table t = Table.create(str).addColumns(
                        StringColumn.create("title", testMap.keySet()),
                        DoubleColumn.create("frequency",testMap.values()));
        return t;
    }

}
