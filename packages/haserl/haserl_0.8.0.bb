DESCRIPTION = "A cgi wrapper for embedding shell scripts into html documents"
SECTION = "console/network"
DEPENDS = ""
FILE_PR = "r0"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${PN}-${PV}.tar.gz"

inherit autotools gettext
