DESCRIPTION = "GLib-based DBus bindings for shr-project.org"
AUTHOR = "Klaus 'mrmoku' Kurzmann"
LICENSE = "LGPL"
SECTION = "devel"
DEPENDS = "gdbus-binding-tool glib-2.0 shr-specs"
SRCREV = "926654296339d88f69cd481d1cf8eb9facdf9bf3"
PV = "2011.01.04.1+gitr${SRCPV}"
PR = "r0"

inherit autotools

SRC_URI = "git://git.shr-project.org/repo/libshr-glib.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

do_configure_prepend() {
       sed -i -e s#SHR_SPECS_DIR="#SHR_SPECS_DIR="${STAGING_DIR_HOST}/#g ${S}/configure.ac
}
