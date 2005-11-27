DESCRIPTION = "RFC2425 MIME Directory Profile library, supporting vCard and iCalendar"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "intltool-native"
PR = "r1"

DEFAULT_PREFERENCE = 1

SRC_URI = "http://www.rittau.org/mimedir/${P}.tar.gz"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-gtk-doc"

do_stage() {
autotools_stage_all
}


PACKAGES += libmimedir-utils
FILES_libmimedir-utils = "${bindir}"
FILES_${PN} = "${libdir}"
