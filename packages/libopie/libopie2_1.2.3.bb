require ${PN}.inc

PR = "r6"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/libopie2 \
           file://include.pro \
           file://gcc-syntax-fix.patch;patch=1 \
           file://h4000_and_default_rot.patch;patch=1 \
           file://ipaq_rotate_fix.patch;patch=1 \
           file://spitz_rotate_fix.patch;patch=1 \
           file://c7x0_w100_disable.patch;patch=1"

SRC_URI_append_poodle = " file://poodle-2.6-hotkeys.patch;patch=1"
