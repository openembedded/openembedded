DESCRIPTION = "pwsafe is a unix commandline program that manages encrypted password databases."
AUTHOR = "Nicolas S. Dade <ndade@nsd.dyndns.org>"
HOMEPAGE = "http://pwsafe.sf.net"
# SECTION
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = "openssl readline"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"

inherit autotools

# zecke-workaround ;-)  Thanks.  Should contact upstream to fix their stuff
EXTRA_OECONF = " --with-openssl-dir=/bla/bla"

do_configure_prepend() {
	rm ${S}/configure
}

SRC_URI[md5sum] = "4bb36538a2772ecbf1a542bc7d4746c0"
SRC_URI[sha256sum] = "61e91dc5114fe014a49afabd574eda5ff49b36c81a6d492c03fcb10ba6af47b7"
