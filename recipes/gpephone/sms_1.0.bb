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

SRC_URI[md5sum] = "7c11b59753ae8fea2c1f1030c34bff42"
SRC_URI[sha256sum] = "7b408a4e7eb5c4fa6861e3d5f0b49f5ce872c87775fb302a7d36956b77f1e2b9"
