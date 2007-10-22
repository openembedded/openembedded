DESCRIPTION = "The OpenMoko Calendar"
SECTION = "openmoko/pim"
DEPENDS = "libmokoui2 libmokojournal2 gtk+ libglade eds-dbus"
RDEPENDS = "libedata-cal"
PV = "0.1.0+svnr${SRCREV}"

inherit openmoko2

SRC_URI = "svn://svn.o-hand.com/repos/dates/branches;module=jana;proto=http"
S = "${WORKDIR}/jana/"

EXTRA_OECONF = "--with-frontend=openmoko"

do_configure_prepend() {
	touch gtk-doc.make
}

