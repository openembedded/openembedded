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
