DESCRIPTION = "A Python Widget library based on python-curses."
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "LGPL"
RDEPENDS = "python-core python-curses"
SRCNAME = "urwid"

SRC_URI = "http://excess.org/urwid/urwid-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
