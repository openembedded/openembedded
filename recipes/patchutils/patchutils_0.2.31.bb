SECTION = "devel"
LICENSE = "GPL"
DESCRIPTION = "Patchutils is a small collection of programs that operate on patch files."

SRC_URI = "http://cyberelk.net/tim/data/patchutils/stable/patchutils-${PV}.tar.bz2"

inherit autotools

do_configure_prepend() {
        sed -i -e s:AC_CONFIG_SRCDIR:#AC_CONFIG_SRCDIR:g configure.in
}

do_configure() {
       gnu-configize
       libtoolize --force
       oe_runconf
}       


