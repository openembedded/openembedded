DESCRIPTION = "freesmartphone.org API GLib wrapper (auto-generated)"
SECTION = "devel"
LICENSE = "LGPL-3"
DEPENDS = "dbus-glib fso-specs"
SRCREV = "e2ba3e01a1b133854c8e32cd611e56923896c7de"
PV = "2011.04.15.1+gitr${SRCPV}"

inherit autotools pkgconfig

SRC_URI = "${FREESMARTPHONE_GIT}/libfreesmartphone-glib.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

do_configure_prepend() {
       sed -i -e s#FSO_SPECS_DIR="#FSO_SPECS_DIR="${STAGING_DIR_HOST}/#g ${S}/configure.ac
}
