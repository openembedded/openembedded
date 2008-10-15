DESCRIPTION = "A Python Widget library based on python-curses."
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
RDEPENDS = "python-curses"
SRCNAME = "urwid"
PR = "ml0"

SRC_URI = "http://excess.org/urwid/urwid-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
