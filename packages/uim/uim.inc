DESCRIPTION = "A multilingual user input method library"
HOMEPAGE = "http://uim.freedesktop.org/"
LICENSE = "GPL"
SECTION = "libs/inputmethod"
PR = "r0"

EXTRA_OECONF += "--disable-applet \
                 --disable-emacs \
                 --without-qt \
                 --without-scim \
                 --without-m17nlib \
                 --without-prime \
                 --without-canna \
                 --without-mana \
                 --without-eb"

SRC_URI = "http://uim.freedesktop.org/releases/uim-${PV}.tar.gz"

S = "${WORKDIR}/uim-${PV}"
