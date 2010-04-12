DEFAULT_PREFERENCE = "-1"

include libxcb.inc
SRCREV = "a63fbc9d6c484e5ad7a5e9d56f81b8e1a2f38a82"
PV = "1.6+git"
PR = "r0"

DEPENDS += "libpthread-stubs"

SRC_URI = "git://anongit.freedesktop.org/xcb/libxcb;protocol=git"
S = "${WORKDIR}/git"

PACKAGES =+ "libxcb-xinerama"
