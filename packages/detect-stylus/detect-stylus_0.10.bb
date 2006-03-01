inherit gpe pkgconfig
LICENSE = "GPL"

PR = "r2"

DEPENDS = "libx11 xrdb xcursor-transparent-theme"
RDEPENDS = "xrdb xcursor-transparent-theme"
SECTION = "gpe"

DESCRIPTION = "Touchscreen detection utility"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.gz"

export CVSBUILD="no"
