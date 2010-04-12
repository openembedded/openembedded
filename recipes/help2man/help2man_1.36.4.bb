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

SRC_URI[md5sum] = "d31a0a38c2ec71faa06723f6b8bd3076"
SRC_URI[sha256sum] = "a4adadf76b496a6bc50795702253ecfcb6f0d159b68038f31a5362009340bca2"
