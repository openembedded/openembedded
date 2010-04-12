DESCRIPTION = "Gabble: a Jabber/XMPP connection manager"
HOMEPAGE = "http://telepathy.freedesktop.org/wiki/"
DEPENDS = "glib-2.0 dbus loudmouth telepathy-glib"
LICENSE = "LGPL"

# gabble.manager needs to get regenerated every release, so please don't copy it over blindly
SRC_URI = "http://telepathy.freedesktop.org/releases/telepathy-gabble/${P}.tar.gz \
           file://gabble.manager"

inherit autotools_stage 
AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_compile_prepend() {
      cp ${WORKDIR}/gabble.manager ${S}/data/
}

FILES_${PN} += "${datadir}/telepathy \
		${datadir}/dbus-1"

SRC_URI[md5sum] = "0bd4fdfb63d86d5e297ae069ad489704"
SRC_URI[sha256sum] = "9a4ce52bd7eb9b8010a481be71117d814eb15fe9c8579817c7b486199a3801ac"
