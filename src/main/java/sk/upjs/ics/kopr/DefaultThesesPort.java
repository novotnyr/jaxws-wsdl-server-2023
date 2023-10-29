package sk.upjs.ics.kopr;

import https.kopr_ics_upjs.Theses;
import https.kopr_ics_upjs.ThesesPortType;
import jakarta.jws.WebService;

import java.util.List;


@WebService(endpointInterface = "https.kopr_ics_upjs.ThesesPortType")
public class DefaultThesesPort implements ThesesPortType {
    @Override
    public List<Theses.Thesis> search(String author, List<String> keyword) {
        var thesis = new Theses.Thesis();
        thesis.setAuthor(author);
        thesis.setYear(2023);
        thesis.setTitle("Of Wolves and Men and " + String.join(" ", keyword));

        return List.of(thesis);
    }
}
