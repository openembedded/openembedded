require ${PN}.inc
PV = "${OPIE_CVS_PV}"
PR = "r16"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/apps/calibrate \
           ${HANDHELDS_CVS};module=opie/noncore/settings/mediummount \
           ${HANDHELDS_CVS};module=opie/core/launcher \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps \
           ${HANDHELDS_CVS};module=opie/root \
           ${HANDHELDS_CVS};module=opie/etc \
           file://nomax.patch;patch=1;pnum=3 \
           file://no-builtin-qss-startup.patch;patch=1 \
           file://kbdlocks-runtime.patch;patch=1 \
	   file://restart-from-bindir.patch;patch=1 \
           file://server.pro \
	   file://firstuse-path.patch;patch=1 \
          "
