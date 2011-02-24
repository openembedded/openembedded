DESCRIPTION = "GLib-based DBus bindings for shr-project.org"
AUTHOR = "Klaus 'mrmoku' Kurzmann"
LICENSE = "LGPL"
SECTION = "devel"
DEPENDS = "gdbus-binding-tool glib-2.0 shr-specs"
SRCREV = "761dea6463326714c00342cb53ba28a1c2dfea63"
PV = "2011.01.04.1+gitr${SRCPV}"
PR = "r0"

inherit autotools

SRC_URI = "git://git.shr-project.org/repo/libshr-glib.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

do_configure_prepend() {
       sed -i -e s#SHR_SPECS_DIR="#SHR_SPECS_DIR="${STAGING_DIR_HOST}/#g ${S}/configure.ac
}
