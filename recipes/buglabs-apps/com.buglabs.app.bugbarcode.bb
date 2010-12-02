require bug-app.inc

DESCRIPTION = "BugBarcode is a simple barcode reader for the BUG.  To use it, attach the camera and the LCD, point the camera at a barcode and press hotkey 1.  It uses ZXing4Bug to do the barcode processing, so make sure you install that as well.  Right now due to limitations with the BUGCam's ability to do macro focusing, BugBarcode has trouble with small barcodes.\
If you want to use BugBarcode on a virtual bug, comment out line 95 in BugBarcodeApp.java, uncomment line 98, and replace the placeholder path with a path to your image (feel free to use the application image on this page)."
HOMEPAGE = "http://buglabs.net/applications/BugBarcode"

DEPENDS += "com.buglabs.bug.module.camera service-tracker com.buglabs.bug.module.lcd com.buglabs.app.zxing4bug com.buglabs.common com.buglabs.osgi "

PV = "4"

SRC_LINK = "http://buglabs.net/program_version/download/242"

APIVERSION = ""
