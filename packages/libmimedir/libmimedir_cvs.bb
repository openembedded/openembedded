DESCRIPTION = "RFC2425 MIME Directory Profile library, supporting vCard and iCalendar"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "intltool-native"
PR = "r4"
PV = "0.3.1+cvs-${CVSDATE}"

DEFAULT_PREFERENCE = 1

SRC_URI = "cvs://anonymous@anoncvs.gnome.org/cvs/gnome;module=libmimedir;tag=branch-mimedir-0-3"
S = "${WORKDIR}/libmimedir"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-gtk-doc"


do_stage() {
autotools_stage_all
}

PACKAGES += libmimedir-utils
FILES_libmimedir-utils = "${bindir}"
FILES_${PN} = "${libdir}/*.so.*"
