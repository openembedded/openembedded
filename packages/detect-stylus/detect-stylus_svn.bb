DESCRIPTION = "Touchscreen detection utility"
SECTION = "gpe"
LICENSE = "GPL"
DEPENDS = "virtual/libx11 xcursor-transparent-theme xrdb"
RDEPENDS = "xrdb"
PV = "0.13+svn${SRCDATE}"
FILE_PR = "r0"

inherit gpe pkgconfig

SRC_URI = "${GPE_SVN} \
           file://detect-stylus-svn-build.patch;patch=1"

S = "${WORKDIR}/${PN}"

export CVSBUILD="no"

DEFAULT_PREFERENCE = "-1"
