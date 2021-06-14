package mai.user;

import mai.Map.*;

public class Client extends User {

    private int district;

    public Client(String nickname, String login, String password, int district) {
        super(nickname, login, password);
        this.district = district;
    }

    public String getDistrict() {
        return City.nameDistricts.get(district);
    }

    public int getDist() {
        return district;
    }
}
