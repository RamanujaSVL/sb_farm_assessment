# sb_farm_assessment
Venuiti Assessment Task

FARM Management.

Endpoints - 
Context mapping - /venuiti/farms

Endpoint 1 - /reports/plantation/{value}

Endpoint 2 - /reports/harvest/{value}

Where value can be either a valid Farm Name or Crop name,
if it's a crop name the respective farm and plantation details are retrieved.
If it's not a recognised crop name then it's assumed to be a Farm name, and if 
the farm name turnout to be invalid, then we return a NO_CONTENT response.

The data source is a mock data consisting of dummy farm names, certain crops like
POTATO, CRON and 2 seasons are configured in the code, additional configurations 
can be made to these requirements.

Unit test cases are handled using Mockito to check the validity of Farm and presence of content.

The data is represented as a JSON in the browser or can tested on POSTMAN.

