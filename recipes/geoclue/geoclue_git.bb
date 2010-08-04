DESCRIPTION = "GeoClue is a project that provide all kinds of geography information to an application"
HOMEPAGE = "http://www.freedesktop.org/wiki/Software/GeoClue"

DEPENDS = "libgpsmgr libgpsbt gtk+ gypsy libxml2 gconf libsoup dbus-glib"

SRCREV = "3a31d260074397a968afaf1065856ab763befb01"
PV = "0.11.1"
PR = "r1"
PR_append = "+gitr${SRCREV}"
PE = "1"

inherit gnome autotools

SRC_URI = "git://anongit.freedesktop.org/git/geoclue;protocol=git \
           file://gtk-doc.make"

S = "${WORKDIR}/git"


LDFLAGS_append = " -lgthread-2.0 "

EXTRA_OECONF = " \
		 --enable-system-bus"

do_configure_prepend() {
	cp ${WORKDIR}/gtk-doc.make ${S}
}


FILES_${PN} += " \
		   ${datadir}/geoclue-providers/ \
           ${datadir}/dbus-1"
