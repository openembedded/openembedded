require ${PN}.inc
PR = "r2"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/libopie2 \
           file://include.pro \
           file://odevice.h-jornada-fixup.patch;patch=1 \
	   file://odevice_jornada.cpp-fixup.patch;patch=1"

SRC_URI_append_poodle = " file://poodle-2.6-hotkeys.patch;patch=1"
