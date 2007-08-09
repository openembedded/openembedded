DESCRIPTION = "GPE network security tool"
SECTION = "gpe"
LICENSE     = "GPL"

DEPENDS     = "libgpewidget iptables virtual/kernel"
RDEPENDS    = "iptables"
RRECOMMENDS = "kernel-module-ipt-state"

PR          = "r1"

inherit gpe pkgconfig

SRC_URI += " file://uncrypt-startup-error.patch;patch=1 "
