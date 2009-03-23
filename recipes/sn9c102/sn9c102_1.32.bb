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

