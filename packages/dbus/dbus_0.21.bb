SECTION = "base"
PR = "r4"
HOMEPAGE = "http://www.freedesktop.org/Software/dbus"
DESCRIPTION = "message bus system for applications to talk to one another"
DEPENDS = "expat glib-2.0 virtual/libintl"
LICENSE = "GPL"

SRC_URI = "http://freedesktop.org/Software/dbus/releases/dbus-${PV}.tar.gz \
	   file://cross.patch;patch=1 \
	   file://dbus-1.init"

inherit autotools pkgconfig update-rc.d gettext

INITSCRIPT_NAME = "dbus-1"
INITSCRIPT_PARAMS = "defaults"

CONFFILES_${PN} = "${sysconfdir}/dbus-1/system.conf ${sysconfdir}/dbus-1/session.conf"

FILES_${PN} += "${libdir}/dbus-1.0/services"
FILES_${PN}-dev += "${libdir}/dbus-1.0/include"

pkg_postinst_dbus() {
#!/bin/sh

# can't do adduser stuff offline
if [ "x$D" != "x" ]; then
  exit 1
fi

MESSAGEUSER=messagebus
MESSAGEHOME=/var/run/dbus

mkdir -p $MESSAGEHOME || true
chgrp "$MESSAGEUSER" "$MESSAGEHOME" 2>/dev/null || addgroup "$MESSAGEUSER"
chown "$MESSAGEUSER"."$MESSAGEUSER" "$MESSAGEHOME" 2>/dev/null || adduser --system --home "$MESSAGEHOME" --no-create-home --disabled-password --ingroup "$MESSAGEUSER" "$MESSAGEUSER"
}

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

do_install_append () {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/dbus-1.init ${D}${sysconfdir}/init.d/dbus-1
	install -d ${D}${libdir}/dbus-1.0/services
}

python populate_packages_prepend () {
	if (bb.data.getVar('DEBIAN_NAMES', d, 1)):
		bb.data.setVar('PKG_dbus', 'dbus-1', d)
}
