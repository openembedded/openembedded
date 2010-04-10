DESCRIPTION = "Drivers for sn9c10x webcams"
LICENSE = "GPL"
HOMEPAGE = "http://www.linux-projects.org/"
SRC_URI = "http://www.linux-projects.org/downloads/${P}.tar.gz"

inherit module

LDFLAGS=""

do_compile() {
oe_runmake KVERSION=${KERNEL_VERSION} KDIR=${STAGING_KERNEL_DIR} modules
}

FILES_${PN} = "/lib/modules/"


SRC_URI[md5sum] = "4d5b5bb9c70e69435a608c73da73b632"
SRC_URI[sha256sum] = "780edfac5a67172a49bc4e8b1bd384fa9184ceaf55bf5ab002fd7b8415db7e3b"
