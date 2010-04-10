LICENSE     = "LiPS"
DESCRIPTION = "Voice call event history"
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "gtk+ dbus-glib libgpewidget libgpephone libiac libchenabler"

inherit gpephone autotools

SRC_URI = "${GPEPHONE_MIRROR}/vochistory-${PV}/callhistory-${PV}.tar.bz2"
S = "${WORKDIR}/callhistory-${PV}"
SRC_URI[md5sum] = "1a3ef24580667be35667b7eefd0f4efe"
SRC_URI[sha256sum] = "1e321eb315eb8c60d5d8ae745d3b48cfe5cb388e73b71760440b590be58c74c7"
