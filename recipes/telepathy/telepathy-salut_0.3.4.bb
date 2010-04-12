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

SRC_URI[md5sum] = "1cf9e0a1c6becbbeb5872e7a77e9fc77"
SRC_URI[sha256sum] = "0eb6e2cccd3e4fa61264507fe984d10cd47ebb125a6f9d5f31cbb3040f57b36c"
