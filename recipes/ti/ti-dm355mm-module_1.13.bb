DESCRIPTION = "User space DMA module for DM355"
SECTION = "devel"
LICENSE = "GPLv2"

require ti-paths.inc
require ti-staging.inc
require ti-eula-unpack.inc

inherit module

PV = "1_13_000"

SRC_URI	= "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/dvsdk/codecs/dm355_codecs_setuplinux_${PV}.bin \
		   file://dm355mm.patch;patch=1 \
	      "
S = "${WORKDIR}/dm355_codecs_${PV}"
BINFILE="dm355_codecs_setuplinux_${PV}.bin"
TI_BIN_UNPK_CMDS = "y:Y: qY:workdir"

#This is a kernel module, don't set PR directly
MACHINE_KERNEL_PR_append = "b"

do_configure() {
	find ${S} -name "*.ko" -exec rm {} \; || true
	sed -i -e s:include:#include:g ${S}/dm355mm/Rules.make
}

do_compile() {
    unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS

    cd ${S}/dm355mm/module
    make \
      LINUXKERNEL_INSTALL_DIR="${STAGING_KERNEL_DIR}" \
      MVTOOL_PREFIX="${TARGET_PREFIX}";
}

do_install () {
    install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
    install -m 0755 ${S}/dm355mm/module/dm350mmap.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
}

INHIBIT_PACKAGE_STRIP = "1"
