package Business.Enterprise;

import Business.Organization.Organization;
import Business.Pet.BoardingRecordDirectory;
import java.util.ArrayList;

/**
 * Enterprise for pet boarding service.
 */
public class PetBoardingEnterprise extends Enterprise {
    private BoardingRecordDirectory boardingRecordDirectory; // 新增成员变量

    public PetBoardingEnterprise(String name) {
        super(name, EnterpriseType.PetBoarding);
        boardingRecordDirectory = new BoardingRecordDirectory(); // 初始化
    }
// 新增 getBoardingRecordDirectory 方法
    public BoardingRecordDirectory getBoardingRecordDirectory() {
        return boardingRecordDirectory;
    }
    @Override
    public ArrayList<Organization.Type> getSupportedOrganizationTypes() {
        ArrayList<Organization.Type> list = new ArrayList<>();
        // Departments inside pet boarding enterprise
        list.add(Organization.Type.FrontDesk);
        list.add(Organization.Type.PetCare);
        list.add(Organization.Type.BoardingService);
        return list;
    }
}
