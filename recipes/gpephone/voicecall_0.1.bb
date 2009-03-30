LICENSE     = "LiPS"
DESCRIPTION = "Voice call application (with wifi support)"
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "gtk+ dbus-glib libgpewidget libgpephone libiac libvocenabler libabenabler libchenabler"

inherit gpephone autotools
