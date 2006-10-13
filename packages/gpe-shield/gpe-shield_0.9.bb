DESCRIPTION = "GPE network security tool"
SECTION     = "gpe"
LICENSE     = "GPL"

DEPENDS     = "libgpewidget iptables virtual/kernel"
RDEPENDS    = "iptables"
RRECOMMENDS = "kernel-module-ipt-state"

PR          = "r0"

inherit gpe pkgconfig


