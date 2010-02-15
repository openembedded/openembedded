LICENSE = "GPLv3 LGPLv3"
PV = "0.1.0+svnr${SRCPV}"

PR = "r4"

require e-module.inc

SRC_URI += "file://fix-api.diff;patch=1;maxrev=39830;pnum=3"

do_configure_prepend() {
       sed -i -e /po/d -e /AM_GNU_GETTEXT/d configure.ac 
       sed -i -e s:\ po::g Makefile.am
}

# Calls /usr/bin/eject for media
RRECOMMENDS_${PN} += "eject"



