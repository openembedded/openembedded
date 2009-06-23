DESCRIPTION = "User space DMA module for DM355"

require ti-codec-combo-dm355.inc
inherit module
# compile and run time dependencies
DEPENDS 	= "virtual/kernel perl-native"
RDEPENDS 	= "update-modules"

SRC_URI	= "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/dvsdk/codecs/dm355_codecs_setuplinux_1_13_000.bin \
		   file://dm355mm_1_30.patch;patch=1 \
	      "
S = "${WORKDIR}/dm355_codecs_1_13_000"
BINFILE="dm355_codecs_setuplinux_1_13_000.bin"

# Yes, the xdc stuff still breaks with a '.' in PWD
PV = "113"
#This is a kernel module, don't set PR directly
MACHINE_KERNEL_PR_append = "a"

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

pkg_postinst () {
    if [ -n "$D" ]; then        
                exit 1
        fi
        depmod -a
        update-modules || true
}

pkg_postrm () {
        update-modules || true
}

INHIBIT_PACKAGE_STRIP = "1"
FILES_${PN} = "/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/dm350mmap.ko"


