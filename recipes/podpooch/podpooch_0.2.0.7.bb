DESCRIPTION = "A podcast downloader/player"
AUTHOR = "Tim Abell et al"
HOMEPAGE = "http://wiki.openmoko.org/wiki/PodPooch"
SECTION = "x11/applications"
PRIORITY = "optional"
LICENSE = "GPLv3"
DEPENDS = "python"

SRC_URI = "http://www.timwise.co.uk/src/${PN}-${PV}.tar.gz"

inherit distutils

FILES_${PN} += "${datadir}"

SRC_URI[md5sum] = "e2e0045bf13e017bbaa5f5855475e516"
SRC_URI[sha256sum] = "d978d3cb4ec99187309b906a636312827c8fef091df28ba9d7e07a5014017c0a"
