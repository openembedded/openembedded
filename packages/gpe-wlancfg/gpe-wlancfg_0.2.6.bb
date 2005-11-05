PR = "r1"
LICENSE = "GPL"
inherit gpe pkgconfig

DEPENDS = "libgpewidget flex"
SECTION = "gpe"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>"
RDEPENDS = "gpe-su"

DESCRIPTION = "GPE wireless LAN configuration tool"
export CVSBUILD = "no"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.gz \
           file://${FILESDIR}/gpe-wlancfg-makefile.patch;patch=1;pnum=0"
