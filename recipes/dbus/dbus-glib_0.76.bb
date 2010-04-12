SECTION = "base"
PR = "r1"
HOMEPAGE = "http://www.freedesktop.org/Software/dbus"
DESCRIPTION = "message bus system for applications to talk to one another"
LICENSE = "GPL"
DEPENDS = "expat glib-2.0 virtual/libintl dbus-glib-native dbus"

SRC_URI = "http://dbus.freedesktop.org/releases/dbus-glib/dbus-glib-${PV}.tar.gz \
	   file://no-examples.patch;patch=1 \
	   file://no-introspect.patch;patch=1"

inherit autotools pkgconfig gettext

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${libdir}/dbus-1.0/include ${bindir}/dbus-glib-tool"

do_configure_prepend() {
	install -m 0644 ${STAGING_DATADIR_NATIVE}/dbus/dbus-bus-introspect.xml ${S}/tools/
	install -m 0644 ${STAGING_DATADIR_NATIVE}/dbus/dbus-glib-bindings.h ${S}/tools/
}

do_stage () {
	oe_libinstall -so -C dbus libdbus-glib-1 ${STAGING_LIBDIR}

	autotools_stage_includes
}

FILES_${PN}-dev += "${bindir}/dbus-binding-tool"

SRC_URI[md5sum] = "d3b716a7e798faa1c6a867675f00306a"
SRC_URI[sha256sum] = "8bc083faaf3efdd444a8a44bbcbfea501a7b547736fda3c2d83bfdc9b5b672a3"
