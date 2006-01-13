DESCRIPTION = "RFC2425 MIME Directory Profile library, supporting vCard and iCalendar"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "intltool-native"
PR = "r1"
#Remove the dash below when 0.3.1 changes in PV
PV = "0.3.1+cvs-${SRCDATE}"

DEFAULT_PREFERENCE = -1

SRC_URI = "cvs://anonymous@anoncvs.gnome.org/cvs/gnome;module=libmimedir"
S = "${WORKDIR}/libmimedir"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-gtk-doc"

do_stage() {
	autotools_stage_all
}

PACKAGES += libmimedir-utils
FILES_libmimedir-utils = "${bindir}"
FILES_${PN} = "${libdir}"

