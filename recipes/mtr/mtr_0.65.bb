DESCRIPTION = "mtr combines the functionality of the 'traceroute' and 'ping' programs in a single network diagnostic tool."
HOMEPAGE = "http://www.bitwizard.nl/mtr/"
LICENSE = "GPLv2"
SRC_URI = "ftp://ftp.bitwizard.nl/mtr/mtr-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "--without-gtk"

do_configure() {
	oe_runconf
}
SRC_URI[md5sum] = "32de3cb8f0763e352124ff4fd74690ab"
SRC_URI[sha256sum] = "82da36fd013f33237a26f1a291e21fc041ebfeac90177a82cb8862732d824bc6"
