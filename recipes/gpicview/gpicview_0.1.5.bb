DESCRIPTION = "Extremely lightweight and fast with low memory usage"
LICENSE = "GPL"

DEPENDS = "gtk+"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz"

inherit autotools pkgconfig



SRC_URI[md5sum] = "5c484ea089f5a6455265e1e1f472240e"
SRC_URI[sha256sum] = "7663e1849f3b1f2225a3310f907f86068d7ac5c8957d68fc4a684059b49211ca"
