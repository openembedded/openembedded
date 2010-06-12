DESCRIPTION = "Legacy Om address book application."
SECTION = "openmoko/pim"
DEPENDS = "libmokoui2 libmokojournal2 dbus-glib"
RDEPENDS_${PN} = "libedata-book"
SRCREV = "419"
PV = "0.1.0+svnr${SRCPV}"
PR = "r7"

inherit openmoko2

SRC_URI = "svn://svn.o-hand.com/repos/contacts/branches;module=hito;proto=http"
S = "${WORKDIR}/hito/"

EXTRA_OECONF = "--disable-gnome-vfs --with-frontend=openmoko"
