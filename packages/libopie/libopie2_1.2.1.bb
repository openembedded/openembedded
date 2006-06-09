include ${PN}.inc

PR = "r5"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/libopie2 \
	   file://openzaurus-branding.patch;patch=1 \
	   file://tosa-bl.patch;patch=1 \
	   file://poodle-collie-bl.patch;patch=1 \
           file://include.pro"

SRC_URI_append_poodle = " file://poodle-2.6-hotkeys.patch;patch=1"
