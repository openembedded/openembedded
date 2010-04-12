require zroadmap.inc

PV = "0.0+cvs${SRCDATE}"
PR = "r0"

SRC_URI = "cvs://anonymous:@roadmap.cvs.sf.net/cvsroot/roadmap;module=roadmap \
           file://cross.patch;patch=1;pnum=2 \
           file://options.mk.patch;patch=1;pnum=2 \
           file://qt/qt2-fixes.patch;patch=1 \
           file://roadmap_path.patch;patch=1 \
           http://roadmap.digitalomaha.net/maps/usdir.rdm.tar.gz;name=usdir"

S = "${WORKDIR}/roadmap/src"

SRC_URI[usdir.md5sum] = "d669ae4a3567b0d5d3ff5db6351b4053"
SRC_URI[usdir.sha256sum] = "651f040408a9dfe3ece1d490cd808fc80e878fd39876f50f6772f9e5f9ee3674"
