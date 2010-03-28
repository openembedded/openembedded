DESCRIPTION = "GLib bindings for the dbus message bus system"
HOMEPAGE = "http://www.freedesktop.org/Software/dbus"
SECTION = "libs"
LICENSE = "GPL"
DEPENDS = "expat glib-2.0 virtual/libintl dbus-glib-native dbus"
INC_PR = "r1"

SRC_URI = "\
  http://dbus.freedesktop.org/releases/dbus-glib/dbus-glib-${PV}.tar.gz;name=archive \
  file://no-introspect.patch;patch=1 \
  file://no-examples.patch;patch=1 \
"

inherit autotools pkgconfig gettext

do_configure_prepend() {
	install -m 0644 ${STAGING_DATADIR_NATIVE}/dbus/dbus-bus-introspect.xml ${S}/tools/
	install -m 0644 ${STAGING_DATADIR_NATIVE}/dbus/dbus-glib-bindings.h ${S}/tools/
}

PACKAGES += "${PN}-bash-completion"
FILES_${PN}-bash-completion = "\
  ${sysconfdir}/bash_completion.d \
  ${prefix}/libexec/dbus-bash-completion-helper \
"
FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "\
  ${libdir}/dbus-1.0/include \
  ${bindir}/dbus-glib-tool \
  ${bindir}/dbus-binding-tool \
"
