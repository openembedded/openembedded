# Copyright (C) 2008 Instituto Nokia de Tecnologia
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Mamona-IM Enlightenment Applet"
HOMEPAGE = "http://dev.openbossa.org/trac/mamona/wiki"
LICENSE = "MIT BSD"
DEPENDS = "mamona-input-methods e-wm"
SRCREV = "a1ba7e8a388ffce3cca92bad059cd801e7733a7a"
PV = "0.1-${PR}+gitr${SRCREV}"
PR = "r1"
PE = "1"

SRC_URI = "git://dev.openbossa.org/mamona/projects/mamonaim_e_applet.git;protocol=http"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

do_configure_prepend() {
        ./autogen.sh
}

# E Applet
FILES_${PN} = "\
            ${libdir}/enlightenment/modules/mamonaim/module.desktop \
            ${libdir}/enlightenment/modules/mamonaim/mamonaim.edj \
            ${libdir}/enlightenment/modules/mamonaim/e-module-mamonaim.edj \
            ${libdir}/enlightenment/modules/mamonaim/*.png \
            ${libdir}/enlightenment/modules/mamonaim/*/module.so \
        "
FILES_${PN}-dev = "\
            ${libdir}/enlightenment/modules/mamonaim/*/module.la \
            ${libdir}/enlightenment/modules/mamonaim/*/module.a \
        "
FILES_${PN}-dbg = "\
            ${libdir}/enlightenment/modules/mamonaim/*/.debug \
        "
