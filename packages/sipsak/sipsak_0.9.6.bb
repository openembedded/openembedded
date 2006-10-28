DESCRIPTION = "sipsak is a small command line tool for developers and administrators\
of Session Initiation Protocol (SIP) applications."
HOMEPAGE="sipsak.org"
SRC_URI = "http://download.berlios.de/sipsak/sipsak-${PV}-1.tar.gz"

inherit autotools

do_install () {
install -d ${D}${bindir}
install -m 0755 sipsak ${D}${bindir}/
}
