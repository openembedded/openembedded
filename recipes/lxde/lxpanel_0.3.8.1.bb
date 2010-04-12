DESCRIPTION = "LXDE Panel"
SECTION = "x11"
DEPENDS = ""

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF += "--with-plugins=none"

SRC_URI[md5sum] = "18b03bd5556d14b8bd1adf00f4e95574"
SRC_URI[sha256sum] = "b3d3a06b946dba977007a84035da6667bbaa3617e1aecb83483d6a207c319021"
