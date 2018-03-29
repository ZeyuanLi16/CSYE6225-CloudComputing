# CSYE6225-CloudComputing
 ## New URL 
 studentsys-env-deploy.2p87cpvqbf.us-west-2.elasticbeanstalk.com

## API
| API | GET|	POST|	PUT	|DELETE|
| --- | --- |--- | --- |--- | 
|	Student/	|	1	|	1	|	1	|	0	|
|	Student/{studentid}	|	1	|	0	|	0	|	1	|
|	Student/{studentid}/course/{courseid} |	 0|	 0 |	1 |	1|	
|	Program/	|	1	|	0	|	0	|	0	|
|	Program/{progranid}	|	1	|	1	|	1	|	1	|
|	Program/{progranid}/course	|	1	|	0	|	0	|	0	|
|	Course/	|	1	|	1	|	1	|	0	|
|	Course/{courseid}	|	1	|	0	|	0	|	1	|
|	Course/{courseid}/announcement	|	1	|	1	|	1	|	0	|
|	Course/{courseid}/announcement/{announcementid}	|	1	|	0	|	0	|	1	|
|	Course/{courseid}/lecture	|	1	|	1	|	1	|	0	|
|	Course/{courseid}/lecture/{lectureid}	|	1	|	0	|	0	|	1	|
|	Course/{courseid}/lecture/{lectureid}/note	|	1	|	1	|	1	|	0	|
|	Course/{courseid}/lecture/{lectureid}/note/{notesid}	|	1	|	0	|	0	|	1	|
|	Course/{courseid}/roster	|	1	|	0	|	0	|	0	|
|	Professor/	|	1	|	1	|	1	|	0	|
|	Professor/{professorid}	|	1	|	0	|	0	|	1	|
|	Professor/{professorid}/course	|	1	|	0	|	0	|	0	|

* For now, you have to manually add/cancel course subscription to students using : Student/{studentid}/course/{courseid}
