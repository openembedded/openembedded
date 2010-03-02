SECTION = "x11/base"
LICENSE = "MIT"
SRC_URI = "git://anongit.freedesktop.org/mesa/drm;protocol=git;branch=master"
SRC_URI_shr = "git://git.bitwiz.org.uk/libdrm.git;protocol=git;branch=glamo"

PROVIDES = "drm"
DEPENDS = "libpthread-stubs virtual/kernel"

PE = "1"
PV = "2.4.18+gitr${SRCREV}"
PR = "r0"

SRCREV_pn-libdrm ?= "a5c8f55397377994ceeb76ed0ff148ff89eb3a1b"
SRCREV_pn-libdrm_shr ?= "b5aec2bd3df736216e86eae28e278172d3ba3362"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_shr = "1"

S = "${WORKDIR}/git"

EXTRA_OECONF_append_shr = " --enable-glamo-experimental-api --disable-radeon --disable-intel"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
