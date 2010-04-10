LICENSE = "GPL"
PR = "r2"

inherit gpe pkgconfig

SRC_URI += "file://gpemixer-no-host-includes.patch;patch=1 \
	    file://fix-install.patch;patch=1"

DESCRIPTION = "GPE audio mixer"
DEPENDS = "gtk+ libgpewidget"
SECTION = "gpe"
PRIORITY = "optional"


SRC_URI[md5sum] = "41b1ef201e4583e55a7462f1404de70d"
SRC_URI[sha256sum] = "f8eb8f0c3af15acd5ad8c17fcc6d1ed2a43c35877d68a403eeb5bc1a1f0b3ccf"
