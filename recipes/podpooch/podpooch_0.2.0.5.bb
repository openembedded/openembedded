DESCRIPTION = "A podcast downloader/player"
AUTHOR = "Tim Abell et al"
HOMEPAGE = "http://wiki.openmoko.org/wiki/PodPooch"
SECTION = "x11/applications"
PRIORITY = "optional"
LICENSE = "GPLv3"
DEPENDS = "python"

SRC_URI = "http://www.timwise.co.uk/src/${PN}-${PV}.tgz"

inherit distutils

FILES_${PN} += "${datadir}"
