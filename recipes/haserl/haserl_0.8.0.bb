DESCRIPTION = "A cgi wrapper for embedding shell scripts into html documents"
SECTION = "console/network"
DEPENDS = ""
PR = "r0"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.gz"

inherit autotools gettext

SRC_URI[md5sum] = "bd9195d086566f56634c0bcbbbcbebea"
SRC_URI[sha256sum] = "ba261a21539e1f204ba74590d313c501007e546b54aa9ae7210a99eaf3c097be"
