DESCRIPTION = "Nevow is a next-generation web application templating \
system, based on the ideas developed in the Twisted Woven package. \
Its main focus is on separating the HTML template from both the business \
logic and the display logic, while allowing the programmer to write pure \
Python code as much as possible. It separates your code into 'data' and \
'render' functions, a simplified implementation of traditional MVC."
HOMEPAGE = "http://divmod.org/projects/nevow"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "checkme"
DEPENDS = "twisted-native"
RDEPENDS = "python-unittest"

SRC_URI = "http://divmod.org/static/projects/nevow/Nevow-${PV}.tar.gz"

S = "${WORKDIR}/Nevow-${PV}"

inherit distutils
