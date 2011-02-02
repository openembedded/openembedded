DESCRIPTION = "GNU utility to convert program --help output to a man page"
HOMEPAGE    = "http://www.gnu.org/software/help2man"
SECTION     = "console/utils"
LICENSE     = "GPLv2"
DEPENDS     = "gettext-native perl-native liblocale-gettext-perl-native"
DEPENDS_virtclass-native = "perl-native autoconf-native automake-native"
RDEPENDS_${PN}    = "gettext perl liblocale-gettext-perl"

TARGET_CC_ARCH += "${LDFLAGS}"

SRC_URI = "${GNU_MIRROR}/${BPN}/${BPN}-${PV}.tar.gz"

inherit autotools

BBCLASSEXTEND = "native"

PR = "r3"

# We don't want to reconfigure things
do_configure() {
	oe_runconf
}

do_install_append () {
	# Make sure we use /usr/bin/env perl
	sed -i -e "1s:#!.*:#! /usr/bin/env perl:" ${D}${bindir}/help2man
}

FILES_${PN} += "/usr/lib/hacklocaledir.so"

SRC_URI[md5sum] = "d31a0a38c2ec71faa06723f6b8bd3076"
SRC_URI[sha256sum] = "a4adadf76b496a6bc50795702253ecfcb6f0d159b68038f31a5362009340bca2"
