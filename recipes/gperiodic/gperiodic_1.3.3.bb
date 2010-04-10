DESCRIPTION = "GPeriodic is a periodic table application for Linux. \
It allows you to browse through a periodic table of the elements, \
and view detailed information on each of the elements. \
118 elements are currently listed."
LICENSE = "GPL"
HOMEPAGE = "http://gperiodic.seul.org"
SECTION = "x11/applications"
DEPENDS = "gtk+-1.2"

SRC_URI = "http://gperiodic.seul.org/downloads/gperiodic-${PV}.tar.gz"

inherit autotools

SRC_URI[md5sum] = "8b6344276252635b18572bca17aa62f6"
SRC_URI[sha256sum] = "5858eb726867e8c28f42101dbff7a5234b960f5944c7800939bf39a775147322"
