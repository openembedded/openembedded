require ${PN}.inc

PR = "r6"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/libopie2 \
           file://include.pro \
           file://gcc-syntax-fix.patch \
           file://h4000_and_default_rot.patch \
           file://ipaq_rotate_fix.patch \
           file://spitz_rotate_fix.patch \
           file://c7x0_w100_disable.patch"

SRC_URI_append_poodle = " file://poodle-2.6-hotkeys.patch"
