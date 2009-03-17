DESCRIPTION = "Salut: Link-local XMPP connection manager for the Telepathy framework"
HOMEPAGE = "http://telepathy.freedesktop.org/wiki/"
DEPENDS = "telepathy-glib avahi telepathy-gabble"
LICENSE = "LGPL"

#salut.manager changes every release, don't copy it over blindly!
SRC_URI = "http://telepathy.freedesktop.org/releases/${PN}/${P}.tar.gz \
           file://keep-manager-file.diff;patch=1 \
	   file://salut.manager"

inherit autotools pkgconfig

do_compile_prepend() {
      cp ${WORKDIR}/salut.manager ${S}/data/
}

FILES_${PN} += "${datadir}/telepathy \
		${datadir}/dbus-1"
