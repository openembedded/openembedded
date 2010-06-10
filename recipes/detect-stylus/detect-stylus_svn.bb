DESCRIPTION = "Touchscreen detection utility"
SECTION = "gpe"
LICENSE = "GPL"
DEPENDS = "virtual/libx11 xcursor-transparent-theme xrdb"
RDEPENDS_${PN} = "xrdb"
PV = "0.13+svnr${SRCPV}"
PR = "r1"

inherit gpe pkgconfig

SRC_URI = "${GPE_SVN} \
           file://detect-stylus-svn-build.patch \
           file://install-detect-tsdevice.patch"

S = "${WORKDIR}/${PN}"

export CVSBUILD="no"

DEFAULT_PREFERENCE = "-1"

PACKAGES =+ "detect-tsdevice"

FILES_detect-tsdevice = "${bindir}/detect-tsdevice"

