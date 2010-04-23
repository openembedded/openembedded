DESCRIPTION = "Extremely lightweight and fast with low memory usage"
LICENSE = "GPL"

DEPENDS = "gtk+"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz"

inherit autotools pkgconfig

SRC_URI[md5sum] = "a2de255bf9bdc40746c0dc89b3454a10"
SRC_URI[sha256sum] = "4c85ef5affba0812b22426217871cc18366fa570e195dc43a5e0f17fbc005639"

