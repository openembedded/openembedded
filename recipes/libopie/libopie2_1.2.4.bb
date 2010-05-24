require ${PN}.inc

PR = "r2"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/libopie2 \
           file://include.pro \
           file://libopie2-tosa.patch;apply=yes \
           file://c7x0_w100_disable.patch;apply=yes \
           file://rotate_fix.patch;apply=yes"

SRC_URI_append_poodle = " file://poodle-2.6-hotkeys.patch;apply=yes"
