LICENSE = "GPL"
inherit gnome

DEPENDS += "libxml-parser-perl-native shared-mime-info intltool-native"
RDEPENDS = "shared-mime-info"

PR = "r2"

SRC_URI[archive.md5sum] = "37242776b08625fa10c73c18b790e552"
SRC_URI[archive.sha256sum] = "e8ee6534bd142ee0ed55134a5eb95f6e7f4b8640df2d3669ebd202f6d82f9a0d"
