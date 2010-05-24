require ${PN}.inc

PR = "r6"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/libopie2 \
           file://include.pro \
           file://gcc-syntax-fix.patch;apply=yes \
           file://h4000_and_default_rot.patch;apply=yes \
           file://ipaq_rotate_fix.patch;apply=yes \
           file://spitz_rotate_fix.patch;apply=yes \
           file://c7x0_w100_disable.patch;apply=yes"

SRC_URI_append_poodle = " file://poodle-2.6-hotkeys.patch;apply=yes"
