DESCRIPTION = "BSD replacement for libreadline"
HOMEPAGE = "http://www.thrysoee.dk/editline/"
SECTION = "libs"
LICENSE="BSD-2"
DEPENDS = "ncurses"
PR = "r0"

inherit autotools

SRC_URI = "http://www.thrysoee.dk/editline/${PN}-${PV}-3.0.tar.gz"

S = ${WORKDIR}/${PN}-${PV}-3.0

FILES_${PN} = "${libdir}/libedit.so"

SRC_URI[md5sum] = "eb4482139525beff12c8ef59f1a84aae"
SRC_URI[sha256sum] = "602b385906b6057f52922afc42cafbceadd8bae4be43c9189ea7fa870a561d86"
