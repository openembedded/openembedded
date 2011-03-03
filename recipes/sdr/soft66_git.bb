DESCRIPTION = "Library and tools for Soft66ADD and related SDR radio receivers"
LICENSE = "GPLv3 + LGPLv3"

DEPENDS = "libftdi"

PV = "0.1.2+gitr${SRCPV}"

SRCREV = "a1dab25e73896c90c98227ac8055f227b830d512"
SRC_URI = "git://home.horsten.com/soft66;protocol=git"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

