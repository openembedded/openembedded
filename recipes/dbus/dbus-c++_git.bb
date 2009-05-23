DESCRIPTION = "C++ bindings for dbus"
LICENSE = "LGPL"
SECTION = "libs"
DEPENDS = "dbus dbus-c++-native expat"
PV = "0.0.0+gitr${SRCREV}"
PR = "r2"

# Gitorious branch
#SRC_URI = "git://gitorious.org/dbus-cplusplus/mainline.git;protocol=git;branch=master \
#           file://no-examples.patch;patch=1"

#Async branch
SRC_URI = "git://repo.or.cz/dbus-cxx-async.git;protocol=git;branch=master \
           file://no-examples.patch;patch=1"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

do_compile_prepend() {
	find . -name "Makefile.am" |xargs sed -i -e 's,$(top_builddir)/tools/dbusxx-xml2cpp,dbusxx-xml2cpp,'
}

FILES_${PN}-dbg += "${bindir}/dbusxx-xml2cpp ${bindir}/dbusxx-introspect"
FILES_${PN}-dev += "${bindir}/.dev"
FILES_${PN} = "${libdir}/*.so.*"

