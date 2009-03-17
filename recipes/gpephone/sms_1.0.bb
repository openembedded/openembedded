LICENSE     = "LiPS"
DESCRIPTION = "GSM Short message application"
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r1"

DEPENDS = "gtk+ dbus-glib libmsgenabler libabenabler libiac libgpewidget libgpephone"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpephone autotools

SRC_URI += " file://somefixes.patch;patch=1;pnum=0"

FILES_${PN} += "${datadir}/conf ${datadir}/graphic"
