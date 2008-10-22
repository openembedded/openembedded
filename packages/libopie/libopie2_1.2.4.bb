require ${PN}.inc

PR = "r0"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/libopie2 \
           file://include.pro \
           file://c7x0_w100_disable.patch;patch=1"

SRC_URI_append_poodle = " file://poodle-2.6-hotkeys.patch;patch=1"
