DESCRIPTION = "ushare is a UPnP media server"
LICENSE = "GPL"
HOMEPAGE = "http://ushare.geexbox.org/"
DEPENDS = "libupnp virtual/libiconv virtual/libintl"
SRC_URI = "http://ushare.geexbox.org/releases/ushare-0.9.7.tar.bz2"
S = "${WORKDIR}/ushare-${PV}"
PR = "r1"

inherit autotools
