DESCRIPTION = "GPE network security tool"
SECTION = "gpe"
LICENSE     = "GPL"

DEPENDS     = "libgpewidget iptables virtual/kernel"
RDEPENDS    = "iptables"
RRECOMMENDS = "kernel-module-ipt-state"

PR          = "r1"

inherit gpe pkgconfig

SRC_URI += " file://uncrypt-startup-error.patch;patch=1 "

SRC_URI[md5sum] = "1373a00d9dba5508da579c585c585d6d"
SRC_URI[sha256sum] = "07d2a2d1c1868b292e3c362e4df4bf32c2aa4b6b22e394a9c5448b8cff4075dc"
