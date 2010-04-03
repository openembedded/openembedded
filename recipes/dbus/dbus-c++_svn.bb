DESCRIPTION = "C++ bindings for dbus"
LICENSE = "LGPL"
SECTION = "libs"
DEPENDS = "dbus dbus-c++-native expat"
SRCREV = "13131"

SRC_URI = "svn://dev.openwengo.org/svn/openwengo/wengophone-ng/branches/wengophone-dbus-api/libs;module=dbus;proto=http"
#           file://fix-linking.patch;patch=1"
S = "${WORKDIR}/dbus"

inherit autotools pkgconfig

do_compile_prepend() {
	find . -name "Makefile.am" |xargs sed -i -e 's,$(top_builddir)/tools/dbusxx-xml2cpp,dbusxx-xml2cpp,'
}

FILES_${PN}-dbg += "${bindir}/dbusxx-xml2cpp ${bindir}/dbusxx-introspect"
FILES_${PN}-dev += "${bindir}/.dev"
FILES_${PN} = "${libdir}/*.so.*"

