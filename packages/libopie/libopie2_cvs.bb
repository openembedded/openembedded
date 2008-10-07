require ${PN}.inc

PV = "${OPIE_CVS_PV}"
PR = "r12"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "${HANDHELDS_CVS};module=opie/libopie2 \
           file://c7x0_w100_disable.patch;patch=1 \
           file://include.pro"

# Patches merged upstream, keep for reference (for 1.2.2)
#           file://ipaq-lcd-rotate-cleanup.patch;patch=1 \
#           file://exports.patch;patch=1 \
#	   file://wireless.patch;patch=1"

SRC_URI_append_poodle = " file://poodle-2.6-hotkeys.patch;patch=1"
