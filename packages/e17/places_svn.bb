LICENSE = "GPLv3 LGPLv3"
PV = "0.1.0+svnr${SRCREV}"

require e-module.inc

do_configure_prepend() {
	sed -i -e /po/d configure.ac 
	sed -i -e s:\ po::g Makefile.am
}



