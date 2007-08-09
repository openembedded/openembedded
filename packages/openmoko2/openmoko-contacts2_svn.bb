DESCRIPTION = "The OpenMoko address book"
SECTION = "openmoko/pim"
RDEPENDS = "libedata-book"
PV = "0.1.0+svn${SVNREV}"
PR = "r2"

inherit openmoko2

SRC_URI = "svn://svn.o-hand.com/repos/contacts/branches;module=hito;proto=http"
S = "${WORKDIR}/hito/"

EXTRA_OECONF = "--disable-gnome-vfs --with-frontend=openmoko"
