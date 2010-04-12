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

SRC_URI[md5sum] = "e7869ad91fee76cc1782fe29fe3a989d"
SRC_URI[sha256sum] = "efe7dd9a1c6993d475ae1a653c5fa97a76a36accd468d49b030d81880ca11bef"
