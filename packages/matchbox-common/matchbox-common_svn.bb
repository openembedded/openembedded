DESCRIPTION = "Matchbox window manager common files"
SECTION = "x11/wm"
LICENSE = "GPL"
DEPENDS = "libmatchbox"
PV = "0.9.1+svn${SRCDATE}"
PR = "r1"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "svn://svn.o-hand.com/repos/matchbox/trunk;module=matchbox-common;proto=http"
S = "${WORKDIR}/matchbox-common"

inherit autotools pkgconfig

EXTRA_OECONF = " --enable-pda-folders "

FILES_${PN} = "\
  ${bindir} \
  ${datadir}/matchbox/vfolders \
  ${datadir}/pixmaps"

PACKAGE_ARCH = "all"
