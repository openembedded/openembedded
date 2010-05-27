LICENSE     = "GPL"
DESCRIPTION = "A cellphone application launcher."
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "gtk+ libgpewidget libgpephone libgpelaunch dbus-glib libsettings libxsettings-client"

GPE_TARBALL_SUFFIX= "bz2"
inherit gpephone autotools

FILES_${PN} += '${datadir}/themes'

SRC_URI[md5sum] = "afe554c858175317266701fd18a30a68"
SRC_URI[sha256sum] = "e6d323d29dded45661e158fce101fbc557c88da56ffdd2576934dcca81464edf"
