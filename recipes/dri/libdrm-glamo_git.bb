SECTION = "x11/base"
LICENSE = "MIT"
SRC_URI = "git://git.bitwiz.org.uk/libdrm.git;protocol=git;branch=glamo"
PROVIDES = "drm"
DEPENDS = "libpthread-stubs virtual/kernel"

PV=2.4.4+gitr${SRCPV}

DEFAULT_PREFERENCE = "-1"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
