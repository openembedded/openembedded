DESCRIPTION = "Gabble: a Jabber/XMPP connection manager"
HOMEPAGE = "http://telepathy.freedesktop.org/wiki/"
DEPENDS = "glib-2.0 dbus loudmouth"
LICENSE = "lgpl"
MAINTAINER = "Koen Kooi <koen@dominion.kabel.utwente.nl>"

SRC_URI = "http://telepathy.freedesktop.org/releases/telepathy-gabble/${P}.tar.gz"

inherit autotools pkgconfig


FILES_${PN} += "${datadir}/telepathy \
		${datadir}/dbus-1"
