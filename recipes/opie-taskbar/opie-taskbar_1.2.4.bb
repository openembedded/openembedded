require ${PN}.inc
PR = "r4"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/apps/calibrate \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/settings/mediummount \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/core/launcher \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/root \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/etc \
           file://nomax.patch;patch=1;pnum=3 \
           file://no-builtin-qss-startup.patch;patch=1 \
           file://kbdlocks-runtime.patch;patch=1 \
	   file://restart-from-bindir.patch;patch=1 \
           file://server-pro-1.2.4.patch;patch=1 \
	   file://firstuse-path.patch;patch=1 \
           file://force-firstuse-calibrate.patch;patch=1 \
          "
