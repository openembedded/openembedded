DESCRIPTION = "Program to create simple man pages"
SECTION = "devel"
LICENSE = "GPLv3"
DEPENDS = "gettext-native perl-native liblocale-gettext-perl-native"
DEPENDS_virtclass-native = "perl-native-runtime"
RDEPENDS_pn-help2man = "gettext perl liblocale-gettext-perl"
PR = "r0"

SRC_URI = "${GNU_MIRROR}/${BPN}/${BPN}-${PV}.tar.gz"
SRC_URI[md5sum] = "371b5cc74fe9c2ea3ee1ca23c19b19a8"
SRC_URI[sha256sum] = "3b44a91ef8e722c570a2a2d0e3f1cd249aac25dd2b2692c7792d87b30ed61561"

inherit autotools

EXTRA_OECONF = "--disable-nls"

BBCLASSEXTEND = "native"

# We don't want to reconfigure things as we're using host perl
do_configure() {
	oe_runconf
}
