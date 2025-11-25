package Business;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import java.util.ArrayList;

public class EcoSystem extends Organization {

    private static EcoSystem instance;
    private ArrayList<Network> networkList;

    private EcoSystem() {
        super("EcoSystem");
        networkList = new ArrayList<>();
    }

    public static EcoSystem getInstance() {
        if (instance == null) {
            instance = new EcoSystem();
        }
        return instance;
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public Network createAndAddNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SystemAdminRole());
        return roles;
    }
}
