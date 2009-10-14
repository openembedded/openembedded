SECTION = "x11/base"
LICENSE = "MIT"
SRC_URI = "git://anongit.freedesktop.org/mesa/drm;protocol=git;branch=master"
#SRC_URI_om-gta02 = "git://git.bitwiz.org.uk/libdrm.git;protocol=git;branch=glamo"
SRC_URI_append_om-gta02 = " file://libdrm-glamo.am.patch;patch=1"

PROVIDES = "drm"
DEPENDS = "libpthread-stubs virtual/kernel"

PV=2.4.15+gitr${SRCPV}

PR = "r1"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_om-gta02 = "1"

S = "${WORKDIR}/git"

EXTRA_OECONF_append_om-gta02 = " --enable-glamo-experimental-api --disable-intel"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
