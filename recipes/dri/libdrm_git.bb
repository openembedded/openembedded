require libdrm.inc
SRC_URI = "git://anongit.freedesktop.org/mesa/drm;protocol=git;branch=master"
SRC_URI_shr = "git://git.bitwiz.org.uk/libdrm.git;protocol=git;branch=glamo"

DEPENDS = "libpthread-stubs virtual/kernel"

PR = "${INC_PR}.0"

PV = "2.4.20+gitr${SRCPV}"

SRCREV = "a3305b076c005e0d3bd55da0214e91413cf65b48"
SRCREV_shr = "9411b0ca002b34d2d13a132038170c2e7b08945c"

DEFAULT_PREFERENCE = "-1"

S = "${WORKDIR}/git"

EXTRA_OECONF_append_shr = " --enable-glamo-experimental-api --disable-radeon --disable-intel"
