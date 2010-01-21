DESCRIPTION = "Client and server side SOAP implementation"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r1"

SRC_URI = "http://www.cpan.org/authors/id/M/MK/MKUTTER/SOAP-Lite-${PV}.tar.gz"

S = "${WORKDIR}/SOAP-Lite-${PV}"

inherit cpan

do_configure_prepend () {
	sed -i '/^use diagnostics;$/d' Makefile.PL
}

BBCLASSEXTEND="native"
