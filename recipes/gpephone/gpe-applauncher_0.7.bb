LICENSE     = "GPL"
DESCRIPTION = "A cellphone application launcher."
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r1"

DEPENDS = "gtk+ libgpewidget libgpephone libgpelaunch dbus-glib libxsettings-client"

GPE_TARBALL_SUFFIX= "gz"
inherit gpephone autotools

SRC_URI += " file://default-icon.patch;patch=1;pnum=0"

#EXTRA_OECONF = "--enable-gridlayout"

FILES_${PN} += '${datadir}/themes'

SRC_URI[md5sum] = "2eaedfe736b88624c360ddda2b6fa777"
SRC_URI[sha256sum] = "2afd5a23705fe95f6abc12e842f2ebaaa038bd4c8cf8a971a848a48a14e100bc"
