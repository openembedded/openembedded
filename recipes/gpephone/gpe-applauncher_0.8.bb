LICENSE     = "GPL"
DESCRIPTION = "A cellphone application launcher."
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "gtk+ libgpewidget libgpephone libgpelaunch dbus-glib libsettings"

GPE_TARBALL_SUFFIX= "bz2"
inherit gpephone autotools

FILES_${PN} += '${datadir}/themes'

SRC_URI[md5sum] = "a4f874b54620e3a5f6c6cfac9e6ba87c"
SRC_URI[sha256sum] = "2955cc5249550f44af484a21aad970b923a5d27a9326f63ed285191a8472239e"
