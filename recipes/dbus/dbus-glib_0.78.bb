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
