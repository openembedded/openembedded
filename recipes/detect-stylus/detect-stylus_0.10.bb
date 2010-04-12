inherit gpe pkgconfig
LICENSE = "GPL"

PR = "r2"

DEPENDS = "virtual/libx11 xrdb xcursor-transparent-theme"
RDEPENDS = "xrdb xcursor-transparent-theme"
SECTION = "gpe"

DESCRIPTION = "Touchscreen detection utility"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.gz"

export CVSBUILD="no"

SRC_URI[md5sum] = "18934b6796441642847ce796bee3b23a"
SRC_URI[sha256sum] = "9ae500ffb1af6e29da00114bad18b776c2f24872c254ee62f6283948beaefc15"
