require roadmap-gtk2.inc

PV = "0.0+cvs${SRCDATE}"
PR = "r1"

SRC_URI = "cvs://anonymous:@roadmap.cvs.sf.net/cvsroot/roadmap;module=roadmap \
           file://cross.patch;patch=1;pnum=2 \
           file://options.mk.patch;patch=1;pnum=2 \
           file://roadmap_path.patch;patch=1 \
	   http://roadmap.digitalomaha.net/maps-1.0.12/usdir.rdm.tgz;name=usdir "

S = "${WORKDIR}/roadmap/src"

SRC_URI[usdir.md5sum] = "7b407c7ff5a38216f85d648365d81894"
SRC_URI[usdir.sha256sum] = "bfa16a53bf481178f0b1bb51fadf539e96312fc3b84f1e54c650d2bae6f1eccb"
