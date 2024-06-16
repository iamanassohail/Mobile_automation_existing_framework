package apiCollection;

import general.EnvGlobals;

import java.sql.SQLException;



public class Payloads {
    public Payloads(){}

    public static String getPayload() throws SQLException
    {
        EnvGlobals.requestBody ="{\n" +
                "\t\"is_jurisdiction\" : true,\n" +
                "\t\"serverVersion\" : 0,\n" +
                "\t\"parent_id\" : [\"23b071ac-46c3-42cf-8a96-389c92a31a3e\"],\n" +
                "\t\"location_names\" : [\"Pan Para\"]\n" +
                "}\n";

        return EnvGlobals.requestBody;
    }
}
