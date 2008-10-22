DESCRIPTION = "RFC2425 MIME Directory Profile library, supporting vCard and iCalendar"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "intltool-native"
PR = "r0"

inherit autotools pkgconfig gpe

EXTRA_OECONF = "--disable-gtk-doc"

do_stage() {
    autotools_stage_all
}


PACKAGES += "libmimedir-utils"
FILES_libmimedir-utils = "${bindir}"
FILES_${PN} = "${libdir}/*.so.*"
