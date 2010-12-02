require bug-app.inc

DESCRIPTION = "*NOTE: Only versions through v1.0.4 will work with R1.3; later versions require R1.4+*\
Controls:\
* Shutter button on the BUGcam module takes a picture ('live' mode only)\
* Hotkey 4 toggles between 'live' mode and 'review' mode\
* Hotkey 3 goes to next picture ('review' mode only)\
* Hotkey 2 goes to previous pictures ('review' mode only)\
* Hotkey 1 toggles slide show option ('review' mode only)\
\
Notes:\
The application starts in full-screen 'live' mode. Press Hotkey 4 on the BUGbase to toggle between 'live' mode, which is where you take pictures, and 'review' mode, which is where you can look at the pictures you have taken.\
Images are saved to the application's bundle directory on the MMC/SD card : @/usr/share/java/storage/default/something/data/*.jpg@; you can do @find /usr/share/java/storage -name \*.jpg@ from a shell on your BUG to locate them.\
Images are preserved on the MMC/SD card even when your BUG is powered off, but they will be *lost* if you download a new version of the Camera application, so be sure to copy them off your BUG before upgrading Camera.\
EXIF data is saved to each image for the following fields:\
* Manufacturer (_Bug Labs_)\
* Model (_BUGcam2MP_)\
* Image Width (_1600_)\
* Image Height (_1200_)\
* Timestamp. You will need to set the time on your BUG for this to be correct; see the @date@ and @hwclock@ commands._\
* Geotagging data, if your BUGlocate has a fix.\
If you want more details on exactly which EXIF fields are set, or want to add more or remove some, look at the @ExifDataHandler@ class.\
*All pictures will include geotagging EXIF data if your BUGlocate has a fix.* Please bear this in mind when uploading images to photo sharing sites. If you don't ever want geodata, you can remove the @ExifDataHandler.addGpsInfo@ method and all references to the @IPositionProvider@ service. This is why Camera currently requires the BUGlocate module; eventually this will be optional.\
"
HOMEPAGE = "http://buglabs.net/applications/Camera"

DEPENDS += "service-tracker com.buglabs.bug.module.lcd com.buglabs.bug.module.camera com.buglabs.common com.buglabs.bug.module.gps com.buglabs.bug.base com.buglabs.osgi "

PV = "9"

SRC_LINK = "http://buglabs.net/program_version/download/950"

APIVERSION = ""
