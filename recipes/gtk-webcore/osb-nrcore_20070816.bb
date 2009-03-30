require osb-nrcore.inc

FIXEDSRCDATE = "${@bb.data.getVar('FILE', d, 1).split('_')[-1].split('.')[0]}"
PV = "0.5.0+cvs${FIXEDSRCDATE}"
PR = "r0"

SRC_URI = "cvs://anonymous@gtk-webcore.cvs.sourceforge.net/cvsroot/gtk-webcore;module=NRCore;date=${FIXEDSRCDATE} \
           file://KWIQ-mimetype-segfault.patch;patch=1 \
	   file://KWQKURL-urlcmp.patch;patch=1 \
           file://gcc4-fno-threadsafe-statics-NRCore.patch;patch=1"

S = "${WORKDIR}/NRCore"

DEFAULT_PREFERENCE = "-1"
