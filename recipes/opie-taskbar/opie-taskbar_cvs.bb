require ${PN}.inc
PV = "${OPIE_CVS_PV}"
PR = "r19"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/apps/calibrate \
           ${HANDHELDS_CVS};module=opie/noncore/settings/mediummount \
           ${HANDHELDS_CVS};module=opie/core/launcher \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps \
           ${HANDHELDS_CVS};module=opie/root \
           ${HANDHELDS_CVS};module=opie/etc \
           file://nomax.patch;striplevel=3 \
           file://no-builtin-qss-startup.patch \
           file://kbdlocks-runtime.patch \
           file://restart-from-bindir.patch \
           file://server-pro-cvs.patch \
           file://firstuse-path.patch \
          "

