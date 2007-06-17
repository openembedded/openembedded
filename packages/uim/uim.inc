DESCRIPTION = "A multilingual user input method library"
HOMEPAGE = "http://uim.freedesktop.org/"
LICENSE = "GPL"
SECTION = "inputmethods"

EXTRA_OECONF += "--disable-applet \
                 --disable-emacs \
#                 --without-qt \
                 --without-scim \
                 --without-m17nlib \
                 --without-prime \
                 --without-canna \
                 --without-mana \
                 --without-eb"

SRC_URI = "http://uim.freedesktop.org/releases/uim/stable/uim-${PV}.tar.bz2"

FILES_${PN}-dbg += "${libdir}/*/*/immodules/.debug ${libdir}/uim/plugin"
