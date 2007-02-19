LICENSE     = "GPL"
DESCRIPTION = "A cellphone status panel to be used with gpe-applauncher."
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "gtk+ libgpephone dbus-glib"

GPE_TARBALL_SUFFIX= "gz"
inherit gpephone autotools

FILES_${PN} += "${datadir}/themes"
