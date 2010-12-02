require bug-app.inc

DESCRIPTION = "This is an application in the vein of Hello World for the BUGcam.  \
This is part of an effort to clarify the BUG's API, and how to use the API to make your own applications.  New users are encouraged to check out applications tagged with 'Hello World' to find similar programs for each of the modules, and the BUGbase itself.\
The application is extensively commented.\
What this application requires: Camera module (should work in virtual bug and physical BUG alike).\
\
What this application does: when the Camera module is inserted, the flash will go off and a picture will be pulled from the camera module and written to ./tmp/image.jpeg.\
What this application shows: some of the basic services required to interact with the Camera module, and some ways to do it.\
See also: ImageTest, BUGCam\
"
HOMEPAGE = "http://buglabs.net/applications/BUGcam_helloworld"

DEPENDS += "com.buglabs.bug.module.camera com.buglabs.osgi service-tracker com.buglabs.common "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/309"

APIVERSION = ""
