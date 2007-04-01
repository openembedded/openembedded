require osb-nrcore.inc

DEFAULT_PREFERENCE = "-1"

PV = "0.5.0+svn${SRCDATE}"
PR = "r0"

SRC_URI = "svn://gtk-webcore.svn.sourceforge.net/svnroot/gtk-webcore/trunk;module=NRCore;proto=https \
           file://gcc4-fno-threadsafe-statics-NRCore.patch;patch=1 \
	   file://build_silence.patch;patch=0"

S = "${WORKDIR}/NRCore"

