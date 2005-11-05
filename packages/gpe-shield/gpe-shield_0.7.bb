PR = "r1"
inherit gpe pkgconfig
LICENSE = "GPL"
DEPENDS = "libgpewidget iptables"
RDEPENDS = "iptables"
SECTION = "gpe"
MAINTAINER = "Florian Boor <florian.boor@kernelconcepts.de>"

DESCRIPTION = "GPE network security tool"
SRC_URI += "file://nostropts.patch;patch=1"
