# Copyright (C) 2008 Instituto Nokia de Tecnologia
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Mamona input methods"
HOMEPAGE = "http://dev.openbossa.org/trac/mamona/wiki"
SECTION = "libs/inputmethods"
LICENSE = "GPL"
DEPENDS = "ecore gtk+"
RPROVIDES_${PN} = "libmamona-im0"
RPROVIDES_${PN}-ecore = "libmamona-im-ecore"
RPROVIDES_${PN}-gtk = "libmamona-im-gtk"
SRCREV = "4a8f11973021b8b4f157f5743e00f9f9a3c4802b"
PV = "0.1-${PR}+gitr${SRCREV}"
PR = "r5"
PE = "1"

SRC_URI = "git://dev.openbossa.org/mamona/projects/mamona_input_methods.git;protocol=http"

S = "${WORKDIR}/git"

inherit autotools_stage pkgconfig lib_package

EXTRA_OECONF = "\
        --enable-ecore-im \
        --enable-gtk-im \
        "

do_configure_prepend() {
        ./autogen.sh
}

# Ecore
PACKAGES += "\
            ${PN}-ecore \
            ${PN}-ecore-dev \
            ${PN}-ecore-dbg \
        "
# GTK
PACKAGES += "\
            ${PN}-gtk \
            ${PN}-gtk-dev \
            ${PN}-gtk-dbg \
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
FILES_${PN}-gtk = "\
            ${libdir}/gtk-2.0/*/immodules/mamona-im-gtk-module.so \
        "
FILES_${PN}-gtk-dev = "\
            ${libdir}/gtk-2.0/*/immodules/mamona-im-gtk-module.la \
            ${libdir}/gtk-2.0/*/immodules/mamona-im-gtk-module.a \
        "
FILES_${PN}-gtk-dbg = "\
            ${libdir}/gtk-2.0/*/immodules/.debug \
        "

pkg_postinst_${PN}-gtk() {
        gtk-query-immodules-2.0 > ${sysconfdir}/gtk-2.0/gtk.immodules
}
pkg_postrm_${PN}-gtk() {
        gtk-query-immodules-2.0 > ${sysconfdir}/gtk-2.0/gtk.immodules
}
