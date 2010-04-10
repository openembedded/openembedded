LICENSE     = "LiPS"
DESCRIPTION = "Voice call application (with wifi support)"
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "gtk+ dbus-glib libgpewidget libgpephone libiac libvocenabler libabenabler libchenabler"

inherit gpephone autotools

SRC_URI[md5sum] = "7fa731310c2f5e334ca4eba9c5482965"
SRC_URI[sha256sum] = "f6ddc993d4890b9500a63345f76acd3eb4a04a9190fcd055f323319627bf104e"
