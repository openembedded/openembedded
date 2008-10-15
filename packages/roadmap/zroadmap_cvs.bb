require zroadmap.inc

PV = "0.0+cvs${SRCDATE}"
PR = "r0"

SRC_URI = "cvs://anonymous:@roadmap.cvs.sf.net/cvsroot/roadmap;module=roadmap \
           file://cross.patch;patch=1;pnum=2 \
           file://options.mk.patch;patch=1;pnum=2 \
           file://qt/qt2-fixes.patch;patch=1 \
           file://roadmap_path.patch;patch=1 \
           http://roadmap.digitalomaha.net/maps/usdir.rdm.tar.gz"

S = "${WORKDIR}/roadmap/src"
