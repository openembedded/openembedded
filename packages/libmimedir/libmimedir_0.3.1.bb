DESCRIPTION = "RFC2425 MIME Directory Profile library, supporting vCard and iCalendar"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "intltool-native"
PR = "r2"

DEFAULT_PREFERENCE = 1

SRC_URI = "http://www.rittau.org/mimedir/${P}.tar.gz \
	   file://mimedir-duration.diff;patch=1"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-gtk-doc"

do_stage() {
autotools_stage_all
}


PACKAGES += libmimedir-utils
FILES_libmimedir-utils = "${bindir}"
FILES_${PN} = "${libdir}"
