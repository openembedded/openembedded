LICENSE     = "LiPS"
DESCRIPTION = "Phone services server"
SECTION     = "gpe"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "dbus-glib glib-2.0  libmsgenabler libabenabler"

GPE_TARBALL_SUFFIX= "gz"
inherit gpephone autotools
 
