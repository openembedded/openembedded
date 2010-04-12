DESCRIPTION = "ushare is a UPnP media server"
LICENSE = "GPL"
HOMEPAGE = "http://ushare.geexbox.org/"
DEPENDS = "libupnp virtual/libiconv virtual/libintl"
SRC_URI = "http://ushare.geexbox.org/releases/ushare-0.9.7.tar.bz2"
S = "${WORKDIR}/ushare-${PV}"
PR = "r1"

inherit autotools

SRC_URI[md5sum] = "e978c648f808cf1740b1583a78b922ff"
SRC_URI[sha256sum] = "b09616934c21e10a9bac2d3941bd8585b075ccc10c2f5218a0f652b0e9386a4c"
