DESCRIPTION = "GLib-based DBus bindings for shr-project.org"
AUTHOR = "Klaus 'mrmoku' Kurzmann"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=fad9b3332be894bab9bc501572864b29"
SECTION = "devel"
DEPENDS = "glib-2.0-native glib-2.0 shr-specs"
SRCREV = "de87dda3aaf83bcfa08a0add5d31801ec9a9d85c"
PV = "2011.03.08.2+gitr${SRCPV}"
PR = "r0"

inherit autotools

SRC_URI = "git://git.shr-project.org/repo/libshr-glib.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

do_configure_prepend() {
       sed -i -e s#SHR_SPECS_DIR="#SHR_SPECS_DIR="${STAGING_DIR_HOST}/#g ${S}/configure.ac
}
