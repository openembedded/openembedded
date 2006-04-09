DESCRIPTION = "GPeriodic is a periodic table application for Linux. \
It allows you to browse through a periodic table of the elements, \
and view detailed information on each of the elements. \
118 elements are currently listed."
LICENSE = "GPL"
HOMEPAGE = "http://gperiodic.seul.org"
SECTION = "x11/apps"
DEPENDS = "gtk+-1.2"

SRC_URI = "http://gperiodic.seul.org/downloads/gperiodic-${PV}.tar.gz"

inherit autotools
