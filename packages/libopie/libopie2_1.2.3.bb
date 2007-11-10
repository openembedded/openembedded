require ${PN}.inc

PR = "r1"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/libopie2 \
           file://include.pro \
	   file://gcc-syntax-fix.patch;patch=1"

SRC_URI_append_poodle = " file://poodle-2.6-hotkeys.patch;patch=1"
