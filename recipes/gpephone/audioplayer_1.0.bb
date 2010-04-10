LICENSE     = "LiPS"
DESCRIPTION = "An audio player for GPE phone edition."
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "gtk+ libgpewidget libgpephone dbus-glib libabenabler libiac gstreamer libgemwidget"

GPE_TARBALL_SUFFIX= "bz2"
inherit gpephone autotools

FILES_${PN} += "${datadir}/themes"

SRC_URI[md5sum] = "7df1df597c655fc6e4c5630ec8052b53"
SRC_URI[sha256sum] = "fce50bc26351bbbe31154d9a734cb433ec8fb404efc5febd50c149e5eaf62449"
