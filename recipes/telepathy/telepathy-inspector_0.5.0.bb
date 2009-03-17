DESCRIPTION = "debugging tool for Telepathy developers"
DEPENDS = "glib-2.0 gtk+ libglade dbus-glib"
LICENSE = "LGPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/tapioca-voip/telepathy-inspector-0.5.0.tar.gz \
           file://scons-workaround.patch;patch=1"

inherit scons

FILES_${PN} += "${datadir}/telepathy \
                ${datadir}/dbus-1"
