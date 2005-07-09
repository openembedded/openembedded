PR = "r1"
LICENSE = "GPL"
inherit gpe pkgconfig

DEPENDS = "libgpewidget iptables"
SECTION = "gpe"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>"

DESCRIPTION = "GPE network security tool"
export CVSBUILD = "no"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.gz \
           file://${FILESDIR}/makefile.patch;patch=1;pnum=0"


