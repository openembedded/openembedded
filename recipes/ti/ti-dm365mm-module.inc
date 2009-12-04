DESCRIPTION = "User space DMA module for DM365"

BASE_SRC_URI = "http://install.source.dir.local"

SRC_URI = "${BASE_SRC_URI}/dm365mm_${PV}.tar.gz "

S = "${WORKDIR}/dm365mm_${PV}"

inherit module

do_compile() {
    unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS

    find ${S} -name "*.ko" -exec rm {} \; || true
    cd ${S}/module
    make \
      LINUXKERNEL_INSTALL_DIR="${STAGING_KERNEL_DIR}" \
      MVTOOL_PREFIX="${TARGET_PREFIX}";
}

do_install () {
    install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
    install -m 0755 ${S}/module/dm365mmap.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
}

INHIBIT_PACKAGE_STRIP = "1"
INSANE_SKIP_${PN} = True

