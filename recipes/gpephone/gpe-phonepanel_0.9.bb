LICENSE     = "GPL"
DESCRIPTION = "A cellphone status panel to be used with gpe-applauncher."
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "gtk+ libgpephone dbus-glib libsettings"

GPE_TARBALL_SUFFIX= "bz2"
inherit gpephone autotools

FILES_${PN} += "${datadir}/themes"

SRC_URI[md5sum] = "36bb2575a246b036049f42d0f5b03594"
SRC_URI[sha256sum] = "8864d8be79e16820861254d51a0bfdcfd045d8b41a46ef5833f6bb5b30a9b1c4"
