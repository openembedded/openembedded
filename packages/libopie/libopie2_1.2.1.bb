include ${PN}.inc

PR = "r2"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/libopie2 \
	   file://openzaurus-branding.patch;patch=1 \
           file://include.pro"
	   
SRC_URI_append_poodle = " file://poodle-2.6-hotkeys.patch;patch=1"
