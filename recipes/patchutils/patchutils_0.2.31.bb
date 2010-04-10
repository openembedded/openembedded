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



SRC_URI[md5sum] = "3aa902cb7a57a4aa09427de603ebf17b"
SRC_URI[sha256sum] = "3d087c88f6e2cc8fde8d2ab12ff2f85ca3ecb2c67754d0483d158f2e5802b015"
