require osb-nrcore.inc

FIXEDSRCDATE = "${@bb.data.getVar('FILE', d, 1).split('_')[-1].split('.')[0]}"
PV = "0.5.0+cvs${FIXEDSRCDATE}"
PR = "r1"

SRC_URI = "cvs://anonymous@gtk-webcore.cvs.sourceforge.net/cvsroot/gtk-webcore;module=NRCore;date=${FIXEDSRCDATE} \
	   file://KWIQ-mimetype-segfault.patch;patch=1 \
	   file://setHandle_segfault-fix.patch;patch=1"

S = "${WORKDIR}/NRCore"
