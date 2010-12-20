DESCRIPTION = "freesmartphone.org API GLib wrapper (auto-generated)"
SECTION = "devel"
LICENSE = "LGPL-3"
DEPENDS = "dbus-glib fso-specs"
SRCREV = "1c2050854d62168dbe15dd6e8faca8b3be8b738a"
PV = "2010.12.13.1+gitr${SRCPV}"
PR = "r0"

inherit autotools pkgconfig

SRC_URI = "${FREESMARTPHONE_GIT}/libfreesmartphone-glib.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

do_configure_prepend() {
       sed -i -e s#FSO_SPECS_DIR="#FSO_SPECS_DIR="${STAGING_DIR_HOST}/#g ${S}/configure.ac
}
