# Copyright (C) 2008 Instituto Nokia de Tecnologia
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Mamona input methods"
HOMEPAGE = "http://dev.openbossa.org/trac/mamona/wiki"
LICENSE = "GPL"
SECTION = "x11"
DEPENDS = "ecore"
PR = "r0"

PV = "0.1+git"

inherit autotools pkgconfig lib_package

SRC_URI = "git://dev.openbossa.org/mamona/mamona_input_methods.git;protocol=http"

S = "${WORKDIR}/git"

PACKAGES += "\
            ${PN}-im-ecore \
            ${PN}-im-ecore-dev \
            ${PN}-im-ecore-dbg \
        "

FILES_${PN}-im-ecore = "\
            ${libdir}/ecore/immodules/mamona-im-ecore-module.so \
        "
FILES_${PN}-im-ecore-dev = "\
            ${libdir}/ecore/immodules/mamona-im-ecore-module.la \
            ${libdir}/ecore/immodules/mamona-im-ecore-module.a \
        "
FILES_${PN}-im-ecore-dbg = "\
            ${libdir}/ecore/immodules/.debug \
        "

EXTRA_OECONF = "\
            --enable-ecore-im \
            "

do_configure_prepend() {
    ./autogen.sh
}

do_stage() {
    autotools_stage_all
}
