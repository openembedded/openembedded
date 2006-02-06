PR          = "r0"
LICENSE     = "GPL"
DEPENDS     = "libgpewidget iptables virtual/kernel"
RDEPENDS    = "iptables"
RRECOMMENDS = "kernel-module-ipt-state"
SECTION     = "gpe"
MAINTAINER  = "Florian Boor <florian.boor@kernelconcepts.de>"

DESCRIPTION = "GPE network security tool"

inherit gpe pkgconfig
