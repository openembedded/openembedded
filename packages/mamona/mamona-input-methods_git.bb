# Copyright (C) 2008 Instituto Nokia de Tecnologia
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Mamona input methods"
HOMEPAGE = "http://dev.openbossa.org/trac/mamona/wiki"
LICENSE = "GPL"
SECTION = "libs/inputmethods"
DEPENDS = "ecore gtk+"
PR = "r4"

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

# GTK
PACKAGES += "\
            ${PN}-gtk \
            ${PN}-gtk-dev \
            ${PN}-gtk-dbg \
        "
RPROVIDES_${PN}-gtk = "libmamona-im-gtk"
EXTRA_OECONF += "\
            --enable-gtk-im \
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

do_configure_prepend() {
    ./autogen.sh
}

do_stage() {
    autotools_stage_all
}

pkg_postinst_${PN}-gtk() {
    gtk-query-immodules-2.0 > ${sysconfdir}/gtk-2.0/gtk.immodules
}

pkg_postrm_${PN}-gtk() {
    gtk-query-immodules-2.0 > ${sysconfdir}/gtk-2.0/gtk.immodules
}
