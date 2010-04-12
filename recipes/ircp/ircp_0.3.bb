DEPENDS = "openobex"
LICENSE = "GPL"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/openobex/ircp-${PV}.tar.gz"

EXTRA_OECONF = "--with-openobex=${STAGING_LIBDIR} "

inherit autotools

SRC_URI[md5sum] = "a77124e7efa6b31369404371485179b2"
SRC_URI[sha256sum] = "729da519ffeb604ac0b9b6c6d8123a3fdf17956134e105c04778f13c4d4ce4ae"
