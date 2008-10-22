DESCRIPTION = "RFC2425 MIME Directory Profile library, supporting vCard and iCalendar"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "intltool-native"
PR = "r4"

# 0.3.1 has at least 2 known bugs which may lead to data corruption/loss:
# 1. Arbitrary cutting off of NOTE field during parsing.
# 2. Parsing only one value from CATEGORIES field.
DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://www.rittau.org/mimedir/${P}.tar.gz \
	   file://mimedir-duration.diff;patch=1"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-gtk-doc"

do_stage() {
autotools_stage_all
}


PACKAGES += "libmimedir-utils"
FILES_libmimedir-utils = "${bindir}"
FILES_${PN} = "${libdir}/*.so.*"
