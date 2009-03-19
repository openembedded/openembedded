DESCRIPTION = "VTE-based terminal emulator"
AUTHOR = "David Gómez Espinosa <david@pleyades.net>"
HOMEPAGE = "http://www.pleyades.net/david/sakura.php"
SECTION = "x11/applications"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = "gtk+ (>=2.6) vte (>=0.11)"

SRC_URI = "http://www.pleyades.net/david/projects/sakura/sakura-${PV}.tar.bz2"

inherit cmake

