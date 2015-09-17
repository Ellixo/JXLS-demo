package com.ellixo.jxls;

import com.ellixo.jxls.domain.Medicament;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.jxls.area.Area;
import org.jxls.builder.AreaBuilder;
import org.jxls.builder.xls.XlsCommentAreaBuilder;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.expression.JexlExpressionEvaluator;
import org.jxls.transform.Transformer;
import org.jxls.util.TransformerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JXLS {

    public static void main(String... args) throws IOException {
        CsvMapper mapper = new CsvMapper();

        CsvSchema schema = mapper.schemaFor(Medicament.class).withArrayElementSeparator(';').withColumnSeparator('\t');
        MappingIterator<Medicament> it = mapper.reader(Medicament.class).with(schema).readValues(JXLS.class.getClassLoader().getResource("CIS_bdpm.txt"));

        List<Medicament> medicaments = it.readAll();

        createReport(medicaments);
    }

    private static void createReport(List<Medicament> medicaments) throws IOException {
        AreaBuilder areaBuilder = new XlsCommentAreaBuilder();

        try (InputStream is = JXLS.class.getClassLoader().getResourceAsStream("./BDM.xls")) {
            try (OutputStream os = new FileOutputStream("./BDM_result.xls")) {
                Context context = new Context();
                context.putVar("medicaments", medicaments);

                Transformer transformer = TransformerFactory.createTransformer(is, os);
                JexlExpressionEvaluator evaluator = (JexlExpressionEvaluator) transformer.getTransformationConfig().getExpressionEvaluator();
                Map<String, Object> functionMap = new HashMap<>();
                functionMap.put("joiner", new ListUtil());
                evaluator.getJexlEngine().setFunctions(functionMap);

                areaBuilder.setTransformer(transformer);
                List xlsAreaList = areaBuilder.build();
                Iterator iterator = xlsAreaList.iterator();

                while (iterator.hasNext()) {
                    Area xlsArea = (Area) iterator.next();
                    xlsArea.applyAt(new CellRef(xlsArea.getStartCellRef().getCellName()), context);
                }

                transformer.write();
            }
        }
    }

    public static class ListUtil {

        public String join(List list) {
            StringBuilder builder = new StringBuilder();
            for (Object o : list) {
                if (builder.length() != 0) {
                    builder.append(" / ");
                }
                builder.append(o);
            }
            return builder.toString();
        }

    }
}
