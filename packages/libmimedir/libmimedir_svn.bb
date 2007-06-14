DESCRIPTION = "RFC2425 MIME Directory Profile library, supporting vCard and iCalendar"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "intltool-native"

DEFAULT_PREFERENCE = "-1"

PV = "0.4.1+svn${SRCDATE}"
PR = "r1"

SRC_URI = "${GPE_SVN}"

S = "${WORKDIR}/libmimedir"

inherit autotools pkgconfig lib_package

EXTRA_OECONF = "--disable-gtk-doc"

do_stage() {
        autotools_stage_all
}

PACKAGES += "libmimedir-utils"

FILES_libmimedir-utils = "${bindir}"
FILES_${PN} = "${libdir}/*.so.*"

