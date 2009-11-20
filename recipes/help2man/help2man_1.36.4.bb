DESCRIPTION = "GNU utility to convert program --help output to a man page"
HOMEPAGE    = "http://www.gnu.org/software/help2man"
SECTION     = "console/utils"
LICENSE     = "GPLv2"
DEPENDS     = "gettext-native perl-native liblocale-gettext-perl-native"
RDEPENDS    = "gettext perl liblocale-gettext-perl"

TARGET_CC_ARCH += "${LDFLAGS}"

SRC_URI    = "${GNU_MIRROR}/help2man/${P}.tar.gz"

inherit autotools

PR = "r0"

EXTRA_OECONF += "PERL=/usr/bin/perl"

do_configure () {
	oe_runconf
}

FILES_${PN} += "/usr/lib/hacklocaledir.so"
