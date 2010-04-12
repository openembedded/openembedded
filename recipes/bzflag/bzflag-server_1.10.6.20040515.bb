SECTION = "console/network"
DEPENDS = "adns ncurses"
LICENSE = "LGPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/bzflag/bzflag-${PV}.tar.bz2"
S = "${WORKDIR}/bzflag-${PV}"

inherit autotools

EXTRA_OECONF = "--disable-bzadmin \
		--disable-client"

SRC_URI[md5sum] = "8e3e5fbef3cfa21079eb06269e6b3d8b"
SRC_URI[sha256sum] = "0329e3d0a59e9cc167733ed2b89a0dc2249725642a065cfd385bf1206fe30b19"
