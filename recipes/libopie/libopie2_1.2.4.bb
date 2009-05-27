require ${PN}.inc

PR = "r2"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/libopie2 \
           file://include.pro \
           file://libopie2-tosa.patch;patch=1 \
           file://c7x0_w100_disable.patch;patch=1 \
           file://rotate_fix.patch;patch=1"

SRC_URI_append_poodle = " file://poodle-2.6-hotkeys.patch;patch=1"
