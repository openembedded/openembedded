DESCRIPTION = "GNU Portable Threads replacement with semaphore support"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL LGPL FDL"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/project/bcusdk/pthsem/pthsem_${PV}.tar.gz \
          "

inherit autotools binconfig

do_configure() {
        gnu-configize
        oe_runconf
}
do_install_prepend() {
        cp ${S}/pth-config ${S}/pthsem-config
}

BINCONFIG_GLOB = "pthsem-config"

PARALLEL_MAKE = ""

SRC_URI[md5sum] = "9144b26dcc27e67498d63dd5456f934c"
SRC_URI[sha256sum] = "4024cafdd5d4bce2b1778a6be5491222c3f6e7ef1e43971264c451c0012c5c01"
