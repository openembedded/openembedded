require ${PN}.inc

PV = "1.2.2+cvs${SRCDATE}"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "${HANDHELDS_CVS};module=opie/libopie2 \
           file://ipaq-2.6-sys-class-backlight-support.patch;patch=1 \
           file://include.pro"

SRC_URI_append_poodle = " file://poodle-2.6-hotkeys.patch;patch=1"
