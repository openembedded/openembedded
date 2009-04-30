LICENSE = "GPLv3 LGPLv3"
PV = "0.1.0+svnr${SRCPV}"

PR = "r3"

require e-module.inc

SRC_URI += "file://fix-api.diff;patch=1;maxrev=39830;pnum=3"

# Calls /usr/bin/eject for media
RRECOMMENDS_${PN} += "eject"

do_configure_prepend() {
	sed -i -e /po/d configure.ac 
	sed -i -e s:\ po::g Makefile.am
}



