SECTION = "base"
HOMEPAGE = "http://www.freedesktop.org/Software/dbus"
DESCRIPTION = "message bus system for applications to talk to one another"
DEPENDS = "expat glib-2.0 virtual/libintl"
PROVIDES = "dbus-glib"
LICENSE = "GPL"

SRC_URI = "http://dbus.freedesktop.org/releases/dbus/dbus-${PV}.tar.gz \
	   file://cross.patch;patch=1"

SRC_URI[md5sum] = "8ebff3cb4beec993e9160ff844e0411c"
SRC_URI[sha256sum] = "3923076133c5a3f6c4c66f3fc842c2e05c14cd87b89096811a3cc853ab848577"

inherit autotools pkgconfig gettext

EXTRA_OECONF = "--disable-qt --disable-gtk --disable-tests \
		--disable-checks --disable-xml-docs --disable-doxygen-docs \
		--with-xml=expat --without-x"

headers = "dbus-address.h dbus-bus.h dbus-connection.h dbus-errors.h dbus-macros.h dbus-memory.h dbus-message.h dbus-pending-call.h dbus-protocol.h dbus-server.h dbus-threads.h dbus-types.h dbus.h"

do_stage () {
	oe_libinstall -so -C dbus libdbus-1 ${STAGING_LIBDIR}
	oe_libinstall -so -C glib libdbus-glib-1 ${STAGING_LIBDIR}

	mkdir -p ${STAGING_INCDIR}/dbus-1.0/dbus
	for i in ${headers}; do
		install -m 0644 dbus/$i ${STAGING_INCDIR}/dbus-1.0/dbus/$i
	done

	install -m 0644 glib/dbus-glib.h ${STAGING_INCDIR}/dbus-1.0/dbus/

	mkdir -p ${STAGING_LIBDIR}/dbus-1.0/include/dbus/
	install -m 0644 dbus/dbus-arch-deps.h ${STAGING_LIBDIR}/dbus-1.0/include/dbus/
}
