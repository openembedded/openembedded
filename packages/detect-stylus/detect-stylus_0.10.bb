inherit gpe pkgconfig
LICENSE = "GPL"

PR = "r2"

DEPENDS = "virtual/libx11 xrdb xcursor-transparent-theme"
RDEPENDS = "xrdb xcursor-transparent-theme"
SECTION = "gpe"

DESCRIPTION = "Touchscreen detection utility"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.gz"

export CVSBUILD="no"
