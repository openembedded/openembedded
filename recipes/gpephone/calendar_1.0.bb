LICENSE     = "LiPS"
DESCRIPTION = "Calendar application for GPE Phone Edition"
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "gtk+ libgpewidget libgpephone libgemwidget dbus-glib libcalenabler libiac"

GPE_TARBALL_SUFFIX= "gz"
inherit gpephone autotools

FILES_${PN} += "${datadir}/database ${datadir}/res"

SRC_URI[md5sum] = "eb7be3b85955a1bbe7a0154cbf2f70f9"
SRC_URI[sha256sum] = "7e6425b688a2d4bbeef0904cac52737b232d03fdc4d35866fd03359f2d5f1794"
