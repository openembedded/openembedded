# Copyright (C) 2008 Instituto Nokia de Tecnologia
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Mamona input methods"
HOMEPAGE = "http://dev.openbossa.org/trac/mamona/wiki"
LICENSE = "GPL"
SECTION = "libs/inputmethods"
DEPENDS = "ecore"
PR = "r2"

PV = "0.1+git"

inherit autotools pkgconfig lib_package

SRC_URI = "git://dev.openbossa.org/mamona/projects/mamona_input_methods.git;protocol=http"

S = "${WORKDIR}/git"

# Mamona IM
RPROVIDES_${PN} = "libmamona-im0"

# Ecore
PACKAGES += "\
            ${PN}-ecore \
            ${PN}-ecore-dev \
            ${PN}-ecore-dbg \
        "
RPROVIDES_${PN}-ecore = "libmamona-im-ecore"
EXTRA_OECONF = "\
            --enable-ecore-im \
        "
FILES_${PN}-ecore = "\
            ${libdir}/ecore/immodules/mamona-im-ecore-module.so \
        "
FILES_${PN}-ecore-dev = "\
            ${libdir}/ecore/immodules/mamona-im-ecore-module.la \
            ${libdir}/ecore/immodules/mamona-im-ecore-module.a \
        "
FILES_${PN}-ecore-dbg = "\
            ${libdir}/ecore/immodules/.debug \
        "

# E Applet
PACKAGES += "\
             ${PN}-e-applet \
             ${PN}-e-applet-dev \
             ${PN}-e-applet-dbg \
         "
RPROVIDES_${PN}-e-appet = "libmamona-im-e-applet"
EXTRA_OECONF += "\
            --enable-e-applet \
        "
FILES_${PN}-e-applet = "\
            ${libdir}/enlightenment/modules/mamonaim/module.desktop \
            ${libdir}/enlightenment/modules/mamonaim/mamonaim.edj \
            ${libdir}/enlightenment/modules/mamonaim/e-module-mamonaim.edj \
            ${libdir}/enlightenment/modules/mamonaim/*.png \
            ${libdir}/enlightenment/modules/mamonaim/*/module.so \
        "
FILES_${PN}-e-applet-dev = "\
            ${libdir}/enlightenment/modules/mamonaim/*/module.la \
            ${libdir}/enlightenment/modules/mamonaim/*/module.a \
        "
FILES_${PN}-e-applet-dbg = "\
            ${libdir}/enlightenment/modules/mamonaim/*/.debug \
        "

do_configure_prepend() {
    ./autogen.sh
}

do_stage() {
    autotools_stage_all
}
