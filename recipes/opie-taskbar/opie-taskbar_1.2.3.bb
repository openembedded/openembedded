require ${PN}.inc
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/apps/calibrate \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/settings/mediummount \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/core/launcher \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/root \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/etc \
           file://nomax.patch;apply=yes;striplevel=3 \
           file://no-builtin-qss-startup.patch;apply=yes \
           file://kbdlocks-runtime.patch;apply=yes \
	   file://restart-from-bindir.patch;apply=yes \
           file://server-pro-old.patch;apply=yes \
	   file://firstuse-path.patch;apply=yes \
          "
