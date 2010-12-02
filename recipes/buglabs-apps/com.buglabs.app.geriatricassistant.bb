require bug-app.inc

DESCRIPTION = "This application is the combination of various geriatric assistance ideas(two to be exact). The first function of the application is a more modern 'I've fallen and I can't get up' device which actually attempts to detect when a fall has occurred using the Motion/Accelerometer module. If a fall is detected, a log is posted to a tumblr account (http://www.tumblr.com) complete with an image (generated using the Yahoo! Maps API) which pin-points the location of the fall based on the GPS coordinates retrieved from the GPS module.  The second function of the application is used to help people with memory issues (Alzheimers patients, etc.) by recording images throughout the day and allowing them to review those images in rapid succession before they go to bed, which has been proven to help increase their recollection of events.   \
The GeriatricAssistant employs the following BUG modules:\
Camera (used to take images every 30 seconds to be played back in the evening before the user goes to bed)\
Motion/Accelerometer (used to determine when a free fall has occurred)\
GPS (used to pin-point the exact location of a fall)\
LCD (used to allow interaction with the user, including the playback of recorded images)\
"
HOMEPAGE = "http://buglabs.net/applications/GeriatricAssistant"

DEPENDS += "service-tracker com.buglabs.bug.module.motion com.buglabs.bug.module.lcd com.buglabs.bug.module.camera com.buglabs.common com.buglabs.bug.module.gps com.buglabs.bug.base com.buglabs.osgi "

PV = "2"

SRC_LINK = "http://buglabs.net/program_version/download/152"

APIVERSION = ""

BROKEN = "1"
