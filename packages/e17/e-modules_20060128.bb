DESCRIPTION = "Enlightenment Window Manager Extra Modules"
DEPENDS = "ecore-x11 evas-x11 esmart-x11 edje eet e"
LICENSE = "MIT"
SECTION = "e/apps"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
PR = "r1"

inherit autotools

SRC_URI = "cvs://anonymous@thinktux.net/root;module=e17/apps/e_modules;date=${PV}"
S = "${WORKDIR}/e_modules"

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR}/edje_cc"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir}"

do_compile_prepend() {
        find ${S} -name Makefile | xargs sed -i 's:/usr/include:${STAGING_INCDIR}:'
}