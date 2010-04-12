DESCRIPTION = "debugging tool for Telepathy developers"
DEPENDS = "glib-2.0 gtk+ libglade dbus-glib"
LICENSE = "LGPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/tapioca-voip/telepathy-inspector-0.5.0.tar.gz \
           file://scons-workaround.patch;patch=1"

inherit scons

FILES_${PN} += "${datadir}/telepathy \
                ${datadir}/dbus-1"

SRC_URI[md5sum] = "7fe5810c15edacb0d9c5590d3767f8f0"
SRC_URI[sha256sum] = "16ff39f1d80e6898d0c58e634211254833e6067bd55bc3b4eefabf53cbe6844d"
