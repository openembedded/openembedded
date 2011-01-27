DESCRIPTION = "Client and server side SOAP implementation"
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
DEPENDS = " libmime-tools-perl-native libwww-perl-native libxml-parser-perl-native libtask-weaken-perl-native \
             libio-socket-ssl-perl-native libclass-inspector-perl-native "
RDEPENDS_${PN} = " libmime-tools-perl libwww-perl libxml-parser-perl libtask-weaken-perl \
             libio-socket-ssl-perl libclass-inspector-perl \
	     perl-module-scalar-util perl-module-constant"
PR = "r3"

SRC_URI = "http://www.cpan.org/authors/id/M/MK/MKUTTER/SOAP-Lite-${PV}.tar.gz"

S = "${WORKDIR}/SOAP-Lite-${PV}"

inherit cpan

do_configure_prepend () {
	sed -i '/^use diagnostics;$/d' Makefile.PL
}

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "fd71a0c0feff85f670ab4b2e571652a8"
SRC_URI[sha256sum] = "1767494854716afde371c569cd08edc8bcb5d53360f351c87d6ddfe30c33d492"

