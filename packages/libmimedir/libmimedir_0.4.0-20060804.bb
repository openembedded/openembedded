DESCRIPTION = "RFC2425 MIME Directory Profile library, supporting vCard and iCalendar"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "intltool-native glib-2.0"
PR = "r3"
DEFAULT_PREFERENCE = "5"
SRCDATE = "20060804"
PV = "0.4.0+cvs${SRCDATE}"

SRC_URI = "cvs://anonymous@anoncvs.gnome.org/cvs/gnome;module=libmimedir \
           file://mimedir-update.patch;patch=1 \
           file://mimedir-write-sequence.patch;patch=1;pnum=0 \
	   file://gslist-fix.patch;patch=1"

S = "${WORKDIR}/libmimedir"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-gtk-doc"

do_stage() {
	autotools_stage_all
}

PACKAGES =+ libmimedir-utils
FILES_libmimedir-utils = "${bindir}/*"
