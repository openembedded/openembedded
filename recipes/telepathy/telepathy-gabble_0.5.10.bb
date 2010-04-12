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

SRC_URI[md5sum] = "f3ad7ac1240593033299ccbf86fbc475"
SRC_URI[sha256sum] = "3c4eb81c9d516937565a295beb0e98ab5c2a04864a0a5c8cef32916c63056b05"
