LICENSE = "GPLv3 LGPLv3"
PV = "0.1.0+svnr${SRCREV}"

PR = "r1"

require e-module.inc

# Calls /usr/bin/eject for media
RRECOMMENDS_${PN} += "eject"

do_configure_prepend() {
	sed -i -e /po/d configure.ac 
	sed -i -e s:\ po::g Makefile.am
}



