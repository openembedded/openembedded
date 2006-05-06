DESCRIPTION = "Gabble: a Jabber/XMPP connection manager"
HOMEPAGE = "http://telepathy.freedesktop.org/wiki/"
DEPENDS = "glib-2.0 dbus loudmouth"
LICENSE = "lgpl"
MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"

SRC_URI = "http://ewi546.ewi.utwente.nl/OE/source/telepathy-gabble-${PV}.tar.bz2"

inherit autotools pkgconfig

S = "${WORKDIR}/${PN}/"

FILES_${PN} += "${datadir}/telepathy \
		${datadir}/dbus-1"
