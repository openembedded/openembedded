DESCRIPTION = "Codec Engine for TI ARM/DSP processors - power module"

DEPENDS = "virtual/kernel perl-native dsplink"
RDEPENDS = "update-modules"

inherit module

require ti-paths.inc

PARALLEL_MAKE = ""

do_compile_append() {
	echo "MVTOOL_PREFIX=${TARGET_PREFIX}" > ${S}/Rules.make		
	echo "UCTOOL_PREFIX=${TARGET_PREFIX}" >> ${S}/Rules.make
	echo "LINUXKERNEL_INSTALL_DIR=${STAGING_KERNEL_DIR}"  >> ${S}/Rules.make

	# Build the DSP power manager kernel module
	cd ${S}/cetools/packages/ti/bios/power

	# Unpack all kernel sources for the DSP power manager module
	for dsp in $(ls | grep bld | awk -F, '{print $2}' | awk -F_ '{print $1}') ; do
		if ! [ -e $dsp ] ; then tar xf ti_bios_power,${dsp}_bld.tar ; fi
	done		
	
	cd ${DSPPOWERSOC}/lpm

	unset LDFLAGS CFLAGS	
	make   KERNEL_PATH=${STAGING_KERNEL_DIR}   \
           KERNEL_SRC=${STAGING_KERNEL_DIR}    \
           KERNEL_DIR=${STAGING_KERNEL_DIR}   \
           KERNEL_VERSION=${KERNEL_VERSION}    \
           TOOL_PREFIX=${TARGET_PREFIX} \
           DSPLINK_REPO=${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/ \
           CC="${KERNEL_CC}" LD="${KERNEL_LD}" \
           AR="${KERNEL_AR}"
}


do_install() {
		install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
		cp ${S}/cetools/packages/ti/bios/power/${DSPPOWERSOC}/lpm/*.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp || true
}

INHIBIT_PACKAGE_STRIP = "1"

FILES_ti-lpm-module = "/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/*lpm*ko"

pkg_postinst_ti-lpm-module () {
        if [ -n "$D" ]; then
                exit 1
        fi
        depmod -a
        update-modules || true
}

pkg_postrm_ti-lpm-module () {
        update-modules || true
}


PACKAGE_ARCH = "${MACHINE_ARCH}" 
