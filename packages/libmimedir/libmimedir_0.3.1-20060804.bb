DESCRIPTION = "RFC2425 MIME Directory Profile library, supporting vCard and iCalendar"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "intltool-native glib-2.0"
PR = "r2"
CVSDATE = "20060804"
#Remove the dash below when 0.3.1 changes in PV
PV = "0.3.1+cvs-${CVSDATE}"

SRC_URI = "cvs://anonymous@anoncvs.gnome.org/cvs/gnome;module=libmimedir \
           file://mimedir-update.patch;patch=1 \
           file://mimedir-write-sequence.patch;patch=1;pnum=0"

S = "${WORKDIR}/libmimedir"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-gtk-doc"

do_stage() {
	autotools_stage_all
}

PACKAGES += libmimedir-utils
FILES_libmimedir-utils = "${bindir}"
FILES_${PN} = "${libdir}"
