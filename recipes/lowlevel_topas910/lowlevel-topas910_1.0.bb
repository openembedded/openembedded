DESCRIPTION = "Lowlevel - a simple bootloader for the Toshiba Topas 910."
SECTION = "bootloaders"
PRIORITY = "optional"
LICENSE = "BSD"
PROVIDES = "virtual/bootloader"
DEPENDS = "virtual/kernel"
PR = "r0"

inherit gpe

SRC_URI = "http://www.bplan-gmbh.org/data/toshiba/topas/linux/2.6.26.5/lowlevel_topas910.tar.bz2"


S = "${WORKDIR}/lowlevel/"

CFLAGS_append = " -D__LITTLEENDIAN__ -ffreestanding -I. -include ./arm.h -include ./simple_io32.h"

do_install () {
}

do_deploy () {
        install -d ${DEPLOY_DIR_IMAGE}
        install ${S}/bootstart_tmpa910.bin ${DEPLOY_DIR_IMAGE}/bootstart_tmpa910.bin
	dd if=/dev/full of=/tmp/pad bs=1k count=256
	cat ${S}/bootstart_tmpa910.bin /tmp/pad > /tmp/pad1
	dd if=/tmp/pad1 of=/tmp/pad2 bs=1k count=256
	cat /tmp/pad2 ${DEPLOY_DIR_IMAGE}/zImage-topas910.bin > ${DEPLOY_DIR_IMAGE}/flashimage-topas910.bin
}

do_deploy[dirs] = "${S}"
addtask deploy before do_build after do_compile
