package StepDefinition;

import Covers.ProfessionalIndemnity.ProfessionalIndemnityDetails;
import org.openqa.selenium.WebDriver;

import Covers.MultiCoverQTB.MultiCoverDetails;
import Covers.PublicLiability.PublicLiabilityDetails;
import Covers.ToolInsurance.ToolInsuranceDetails;
import Covers.GoodsinTransit.GoodsinTransitDetails;
public class PageObjectManager {
	public WebDriver Driver;
	public ToolInsuranceDetails ObjToolInsuranceDetails;
	public PublicLiabilityDetails ObjPublicLiabilityDetails;
	public MultiCoverDetails ObjMultiCoverDetails;
	public GoodsinTransitDetails ObjGoodsinTransitDetails;
	public ProfessionalIndemnityDetails ObjProfessionalIndemnityDetails;
	public PageObjectManager(WebDriver driver) {
		this.Driver = driver;
	}

	public ToolInsuranceDetails GetToolInsuranceDetailsPage() {
		ObjToolInsuranceDetails = new ToolInsuranceDetails(Driver);
		return ObjToolInsuranceDetails;
	}

	public PublicLiabilityDetails GetPublicLiabilityDetailsPage() {
		ObjPublicLiabilityDetails = new PublicLiabilityDetails(Driver);
		return ObjPublicLiabilityDetails;
	}

	public MultiCoverDetails GetMultiCoverDetailsPage() {
		ObjMultiCoverDetails = new MultiCoverDetails(Driver);
		return ObjMultiCoverDetails;
	}

	public GoodsinTransitDetails GetGoodsinTransitDetailsPage() {
		ObjGoodsinTransitDetails = new GoodsinTransitDetails(Driver);
		return ObjGoodsinTransitDetails;
	}

	public ProfessionalIndemnityDetails GetProfessionalIndemnityDetailsPage() {
		ObjProfessionalIndemnityDetails = new ProfessionalIndemnityDetails(Driver);
		return ObjProfessionalIndemnityDetails;
	}
}