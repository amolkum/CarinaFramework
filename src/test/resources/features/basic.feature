Feature: Verify the get post in the API 

Background: 
	Given Get the API Base URI 

Scenario: GET all the tests from the API 

	Given Get call to url test the API 
	When Response code is storing PostPet 
	And Update pet details PutPet 
	And Update pet details PostUpdate 
	Then Delete the pet DeletePet