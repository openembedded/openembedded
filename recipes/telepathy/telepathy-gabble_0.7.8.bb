DESCRIPTION = "Gabble: a Jabber/XMPP connection manager"
HOMEPAGE = "http://telepathy.freedesktop.org/wiki/"
DEPENDS = "glib-2.0 dbus loudmouth telepathy-glib"
LICENSE = "LGPL"

# gabble.manager needs to get regenerated every release, so please don't copy it over blindly
SRC_URI = "http://telepathy.freedesktop.org/releases/telepathy-gabble/${P}.tar.gz \
           file://gabble.manager"

inherit autotools pkgconfig

do_compile_prepend() {
      cp ${WORKDIR}/gabble.manager ${S}/data/
}

FILES_${PN} += "${datadir}/telepathy \
		${datadir}/dbus-1"

SRC_URI[md5sum] = "c6fbf9e97f327de6e8737c619bbad738"
SRC_URI[sha256sum] = "820af6a106ee3c2ee019ed5a1d9c6a751020a3d1fdeee84316faf8eff467a721"
