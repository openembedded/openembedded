DESCRIPTION = "GeoClue is a project that provide all kinds of geography information to an application"
HOMEPAGE = "http://www.freedesktop.org/wiki/Software/GeoClue"

DEPENDS = "libgpsmgr libgpsbt gtk+ gypsy libxml2 gconf libsoup dbus-glib"

PE = "1"

inherit gnome

SRC_URI = "http://folks.o-hand.com/jku/geoclue-releases/geoclue-${PV}.tar.gz;name=archive \
           file://gtk-doc.make"

SRC_URI[archive.md5sum] = "33af8307f332e0065af056ecba65fec2"
SRC_URI[archive.sha256sum] = "0f533f177ae9aa35e807a01c754840f66df9579f5524552f14f2b5ba670a4696"


LDFLAGS_append = " -lgthread-2.0 "

EXTRA_OECONF = " \
		 --enable-system-bus"

do_configure_prepend() {
	cp ${WORKDIR}/gtk-doc.make ${S}
}


FILES_${PN} += " \
		   ${datadir}/geoclue-providers/ \
           ${datadir}/dbus-1"
