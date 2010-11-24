DESCRIPTION = "Program to create simple man pages"
SECTION = "devel"
LICENSE = "GPLv3"
DEPENDS = "gettext-native perl-native liblocale-gettext-perl-native"
DEPENDS_virtclass-native = ""
RDEPENDS_pn-help2man = "gettext perl liblocale-gettext-perl"
PR = "r0"

SRC_URI = "${GNU_MIRROR}/${BPN}/${BPN}-${PV}.tar.gz"
SRC_URI[md5sum] = "426671c6fe79e5ef2233303367eab5a6"
SRC_URI[sha256sum] = "952c29561bce8b233aa10af7f0e0c79c8243712810bf8ddf01e6efd82ce250d1"

inherit autotools

EXTRA_OECONF = "--disable-nls"

BBCLASSEXTEND = "native"

# We don't want to reconfigure things as we're using host perl
do_configure() {
	oe_runconf
}
