DESCRIPTION = "Touchscreen detection utility"
SECTION = "gpe"
LICENSE = "GPL"
DEPENDS = "virtual/libx11 xcursor-transparent-theme xrdb"
RDEPENDS = "xrdb"
PV = "0.13+svnr${SRCPV}"
PR = "r0"

inherit gpe pkgconfig

SRC_URI = "${GPE_SVN} \
           file://detect-stylus-svn-build.patch;apply=yes \
           file://install-detect-tsdevice.patch;apply=yes"

S = "${WORKDIR}/${PN}"

export CVSBUILD="no"

DEFAULT_PREFERENCE = "-1"

PACKAGES =+ "detect-tsdevice"

FILES_detect-tsdevice = "${bindir}/detect-tsdevice"

