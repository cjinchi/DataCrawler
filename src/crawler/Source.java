package crawler;

public enum Source {
    OLD_DATAHUB("https://old.datahub.io/api/3/"), DATAGOV("https://catalog.data.gov/api/3/"),
    EUROPEAN_DATA_PORTAL("http://www.europeandataportal.eu/data/api/3/");

    private String header;

    private Source(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }
}
