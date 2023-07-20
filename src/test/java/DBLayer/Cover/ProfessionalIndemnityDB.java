package DBLayer.Cover;

import org.javatuples.Quartet;
import org.javatuples.Triplet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfessionalIndemnityDB {

    public Map<String, Map<String, Triplet<String, String, String>>> DbConnectionString = new HashMap<String, Map<String, Triplet<String, String, String>>>(Map.ofEntries(
            Map.entry("Production", Map.ofEntries(
                            Map.entry("toolbox-pricing", new Triplet<>("\"toolbox-core-dev2.cluster-ro-clg2feyi0u0y.eu-west-1.rds.amazonaws.com/toolbox-pricing\"", "postgres", "fhv476%!fd&"))
                    )
            )
    ));

    public String GetProductPricingRule() {
        return "SELECT \"ProductPricingRule\".\"id\" AS \"id\", \n" +
                "\"ProductPricingRule\".\"no_of_employees\" AS \n" +
                "\"NOE\", \"ProductPricingRule\".\"limit_of_indemnity_id\"\n" +
                "AS \"loiid\", \"ProductPricingRule\".\"trade_id\" AS\n" +
                "\"ProductPricingRule_trade_id\", \"ProductPricingRule\".\n" +
                "\"cover_id\" AS \"coverid\", \"ProductPricingRule\".\"price_multiplier\" AS \"multiplier\",\n" +
                "\"ProductPricingRule\".\"affected_factors\" AS \"EffectedFactors\" FROM \"m_product_pricing_rules\" \n" +
                "\"ProductPricingRule\" WHERE ((( \"ProductPricingRule\".\"trade_id\"= 2617 AND \n" +
                "\t\t\t\t\t\t\t  \"ProductPricingRule\".\"limit_of_indemnity_id\"= 3) OR\n" +
                "\t\t\t\t\t\t\t ( \"ProductPricingRule\".\"no_of_employees\"= 4)) AND \n" +
                "\t\t\t\t\t\t\t\"ProductPricingRule\".\"cover_id\"= 2) OR \n" +
                "\t\t\t\t\t\t\t((( \"ProductPricingRule\".\"trade_id\"= 2617 AND \"ProductPricingRule\".\"limit_of_indemnity_id\"= 6) OR \n" +
                "\t\t\t\t\t\t\t  ( \"ProductPricingRule\".\"no_of_employees\"= 4)) AND\n" +
                " \"ProductPricingRule\".\"cover_id\"= 1)";
    }
}
