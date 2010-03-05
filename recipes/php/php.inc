DESCRIPTION = "A server-side, HTML-embedded scripting language. This package provides the CGI."
HOMEPAGE = "http://www.php.net"
SECTION = "console/network"
LICENSE = "PHP"

SRC_URI =     "http://us2.php.net/distributions/php-${PV}.tar.bz2;name=src\
               file://acinclude-xml2-config.patch;patch=1"

S = "${WORKDIR}/php-${PV}"

inherit autotools

CFLAGS += " -DPTYS_ARE_GETPT -DPTYS_ARE_SEARCHED -D_GNU_SOURCE"

acpaths = ""

do_install  () {
	oe_runmake 'INSTALL_ROOT=${D}' install
}
