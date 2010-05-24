inherit gpe
LICENSE = "GPL"
DEPENDS = "libgpewidget"
SECTION = "gpe"

DESCRIPTION = "GPE Screen light control dockapp"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.gz"

SRC_URI += "file://makefile-fix.patch"

export CVSBUILD="no"
