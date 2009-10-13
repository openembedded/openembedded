DESCRIPTION = "frameworkd EFL phonegui"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "e/apps"
DEPENDS += " dbus-glib libframeworkd-glib libframeworkd-phonegui etk evas ecore edje edje-native elementary"
PV = "0.0.2+gitr${SRCREV}"
PR = "r33"

inherit pkgconfig autotools autotools_stage

SRC_URI = "git://git.shr-project.org/repo/shr.git;protocol=http;branch=master"
S = "${WORKDIR}/git/${PN}"

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

do_configure_prepend() {
        autopoint --force
}

