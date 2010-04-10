LICENSE     = "LiPS"
DESCRIPTION = "GSM Short message application"
SECTION = "gpe"
PRIORITY    = "optional"
PR          = "r0"

DEPENDS = "gtk+ dbus-glib libmsgenabler libabenabler libiac libgpewidget libgpephone"

GPE_TARBALL_SUFFIX = "bz2"

inherit gpephone autotools

FILES_${PN} += "${datadir}/conf ${datadir}/graphic"

SRC_URI[md5sum] = "baa60d94d99c943b136347a5438ad708"
SRC_URI[sha256sum] = "b1118e32a03c245fe1140f968fc6d045dae66a7c092f2e42274e9bae3b7b96b8"
