DESCRIPTION = "Codec Engine for TI ARM/DSP processors - cmemk module"

DEPENDS = "virtual/kernel perl-native"
RDEPENDS = "update-modules"

inherit module

require ti-paths.inc

export DSPLINK="${S}/cetools/packages/dsplink"

PARALLEL_MAKE = ""


do_compile_append() {
	echo "MVTOOL_PREFIX=${TARGET_PREFIX}" > ${S}/Rules.make		
	echo "UCTOOL_PREFIX=${TARGET_PREFIX}" >> ${S}/Rules.make
	echo "LINUXKERNEL_INSTALL_DIR=${STAGING_KERNEL_DIR}"  >> ${S}/Rules.make

	# Build the cmem kernel module
	# We unset CFLAGS because kernel modules need different ones, this is basically a verbatim copy of kernel.bbclass and module-base.bbclass	
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS	
	cd ${S}/cetools/packages/ti/sdo/linuxutils/cmem

	oe_runmake clean
	oe_runmake KERNEL_PATH=${STAGING_KERNEL_DIR}   \
           KERNEL_SRC=${STAGING_KERNEL_DIR}    \
           KERNEL_VERSION=${KERNEL_VERSION}    \
           CC="${KERNEL_CC}" LD="${KERNEL_LD}" \
           AR="${KERNEL_AR}"
}


do_install() {
		install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
		cp ${S}/cetools/packages/ti/sdo/linuxutils/cmem/src/module/cmemk.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
}

INHIBIT_PACKAGE_STRIP = "1"

FILES_ti-cmemk-module = "${sysconfdir} /lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/cmemk.ko"

pkg_postinst_ti-cmemk-module () {
		if [ -n "$D" ]; then        
                exit 1
        fi
        depmod -a
        update-modules || true
}

pkg_postrm_ti-cmemk-module () {
        update-modules || true
}

PACKAGE_ARCH = "${MACHINE_ARCH}" 
