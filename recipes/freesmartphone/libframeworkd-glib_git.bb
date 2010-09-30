DESCRIPTION = "freesmartphone.org API glib wrapper"
LICENSE = "LGPL"
SECTION = "devel"
DEPENDS = "dbus-glib"
SRCREV = "b18ccc4ab399b49b65b33d6efd6216e96032af17"
PV = "0.0.1+gitr${SRCPV}"
PE = "1"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/libframeworkd-glib.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

