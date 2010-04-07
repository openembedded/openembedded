DESCRIPTION = "A GObject Persistence Library"
AUTHOR = "Jürg Billeter, Michael 'Mickey' Lauer"
LICENSE = "LGPL"
SECTION = "devel"
DEPENDS = "libgee"
SRCREV = "217ad803745f8ac1f3c72c6715e2c0faefb3fd06"
PV = "0.1.0+gitr${SRCREV}"
PR = "r0"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/${PN};protocol=git;branch=mickey \
"
S = "${WORKDIR}/git"

inherit autotools_stage pkgconfig vala
