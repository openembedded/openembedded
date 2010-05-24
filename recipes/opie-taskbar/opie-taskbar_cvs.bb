require ${PN}.inc
PV = "${OPIE_CVS_PV}"
PR = "r18"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/apps/calibrate \
           ${HANDHELDS_CVS};module=opie/noncore/settings/mediummount \
           ${HANDHELDS_CVS};module=opie/core/launcher \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps \
           ${HANDHELDS_CVS};module=opie/root \
           ${HANDHELDS_CVS};module=opie/etc \
           file://nomax.patch;apply=yes;striplevel=3 \
           file://no-builtin-qss-startup.patch;apply=yes \
           file://kbdlocks-runtime.patch;apply=yes \
	   file://restart-from-bindir.patch;apply=yes \
           file://server-pro-cvs.patch;apply=yes \
	   file://firstuse-path.patch;apply=yes \
          "

