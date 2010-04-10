SECTION = "base"
PR = "r1"
HOMEPAGE = "http://www.freedesktop.org/Software/dbus"
DESCRIPTION = "message bus system for applications to talk to one another"
LICENSE = "GPL"
DEPENDS = "expat glib-2.0 virtual/libintl dbus-glib-native dbus"

SRC_URI = "http://dbus.freedesktop.org/releases/dbus-glib/dbus-glib-${PV}.tar.gz \
	   file://no-examples.patch;patch=1 \
	   file://no-introspect.patch;patch=1"

inherit autotools_stage gettext
AUTOTOOLS_STAGE_PKGCONFIG = "1"

FILES_${PN} = "${libdir}/lib*.so.* ${libexecdir}/dbus* ${sysconfdir}/profile.d"
FILES_${PN}-dev += "${libdir}/dbus-1.0/include ${bindir}/dbus-glib-tool"

do_configure_prepend() {
	install -m 0644 ${STAGING_DATADIR_NATIVE}/dbus/dbus-bus-introspect.xml ${S}/tools/
	install -m 0644 ${STAGING_DATADIR_NATIVE}/dbus/dbus-glib-bindings.h ${S}/tools/
}

FILES_${PN}-dev += "${bindir}/dbus-binding-tool"

SRC_URI[md5sum] = "d4aa04b9df35b4bd663be38e959941c8"
SRC_URI[sha256sum] = "ca366fed6035f75c6ca038f99b780260a0e19f282067b2dd20243ba54105fc21"
