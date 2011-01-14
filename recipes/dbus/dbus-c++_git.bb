DESCRIPTION = "C++ bindings for dbus"
LICENSE = "LGPLv2.1+"
SECTION = "libs"
DEPENDS = "dbus expat"
SRCREV = "9e25833870ed8281fab00d7f9eac5755c6798c57"

PE = "1"
PV = "0.6.0-pre1+gitr${SRCPV}"

SRC_URI = "git://gitorious.org/dbus-cplusplus/mainline.git;protocol=git"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

FILES_${PN}-dbg += "${bindir}/dbusxx-xml2cpp ${bindir}/dbusxx-introspect"
FILES_${PN}-dev += "${bindir}/.dev"
FILES_${PN} = "${libdir}/*.so.*"

BBCLASSEXTEND = "native"