inherit autotools pkgconfig

DESCRIPTION = "This is an autotool- and libtoolized port of the NetBSD \
Editline library (libedit)."
HOMEPAGE = "http://www.thrysoee.dk/editline/"
SECTION = "libs"
LICENSE = "BSD"
DEPENDS += "ncurses"
PROVIDES += "libedit"
RPROVIDES_${PN} += "libedit"
PR = "r0"

SRC_URI = "http://www.thrysoee.dk/editline/libedit-${PV}.tar.gz"
SRC_URI[md5sum] = "eb4482139525beff12c8ef59f1a84aae"
SRC_URI[sha256sum] = "602b385906b6057f52922afc42cafbceadd8bae4be43c9189ea7fa870a561d86"
S = "${WORKDIR}/libedit-${PV}"

ENABLE_WIDEC ?= "true"
ENABLE_WIDEC[type] = "boolean"

EXTRA_OECONF += "\
    --with-gnu-ld \
    ${@oe.utils.ifelse(oe.data.typed_value('ENABLE_WIDEC', d), \
                       '--enable-widec', '')} \
"
