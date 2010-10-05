require ${PN}.inc

PR = "r3"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/libopie2 \
           file://include.pro \
           file://libopie2-tosa.patch \
           file://c7x0_w100_disable.patch \
           file://rotate_fix.patch"

SRC_URI_append_poodle = " file://poodle-2.6-hotkeys.patch"
