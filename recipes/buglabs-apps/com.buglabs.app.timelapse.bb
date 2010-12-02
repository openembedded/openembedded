require bug-app.inc

DESCRIPTION = "This application creates a time-delayed series of pictures, suitable for use in time-lapse video.\
Enter a time interval and a duration (in milliseconds) in the given fields.  Optionally enter a directory name where the images should be placed.  After you hit Start the application will take one picture per interval for the duration.  Hit Stop to cancel the operation before the full duration has elapsed.\
Impending Features include an improved time-entry interface and playback of stored time-lapse images"
HOMEPAGE = "http://buglabs.net/applications/TimeLapse"

DEPENDS += "service-tracker com.buglabs.bug.module.lcd com.buglabs.bug.module.camera com.buglabs.common com.buglabs.bug.base com.buglabs.osgi "

PV = "6"

SRC_LINK = "http://buglabs.net/program_version/download/140"

APIVERSION = ""
