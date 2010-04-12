LICENSE     = "LiPS"
DESCRIPTION = "Video player application"
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "gtk+ libgpewidget libgpephone libgemwidget dbus-glib gst-plugins-base libiac"

GPE_TARBALL_SUFFIX= "gz"
inherit gpephone autotools

FILES_${PN} += "${datadir}/database ${datadir}/res"

SRC_URI[md5sum] = "405c8780f80f8f117622fa45698328c7"
SRC_URI[sha256sum] = "3cf9b04025015ad06ab3449f20778e34887f5aecdfe367a983ae8e52e394b0df"
