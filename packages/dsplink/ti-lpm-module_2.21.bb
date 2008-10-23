DESCRIPTION = "Codec Engine for TI ARM/DSP processors - power module"

DEPENDS = "virtual/kernel perl-native dsplink"
RDEPENDS = "update-modules"

inherit module

# tconf from xdctools dislikes '.' in pwd :/
PR = "r1"
PV = "221"

# Get CE tarball from TI website, place in sources and calculate
# md5sum
# Look for tarball at https://www-a.ti.com/downloads/sds_support/targetcontent/CE/index.html

SRC_URI = "http://install.tarball.in.source.dir/codec_engine_2_21_00_06.tar.gz \
           file://Makefile.dsplink \
          "

S = "${WORKDIR}/codec_engine_2_21_00_06"

require ti-paths.inc

PARALLEL_MAKE = ""

do_compile() {
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

	export KERNEL_DIR=${STAGING_KERNEL_DIR}
	export TOOL_PREFIX=${TARGET_PREFIX} 

	# Different SoCs use different toolchains by default, we just want them to use the OE one, so replace the entries because they can't be overloaded within the environment
	sed -i -e s:/db/toolsrc/library/tools/vendors/mvl/arm/omap3/OMAP35x_SDK_0.9.7/src/linux/kernel_org/2.6_kernel:${STAGING_KERNEL_DIR}:g \
           -e s:/db/toolsrc/library/tools/vendors/cs/arm/arm-2007q3/bin/arm-none-linux-gnueabi-:${TARGET_PREFIX}:g \
           -e s:/db/atree/library/trees/power/power-d02x/imports:${STAGING_DIR}/${MULTIMACH_TARGET_SYS}:g \
           -e s:/db/toolsrc/library/tools/vendors/mvl/arm/dm6446/REL_LSP_02_00_00_010/montavista/pro/devkit/lsp/ti-davinci/linux-2.6.18_pro500:${STAGING_KERNEL_DIR}:g \
           -e s:/db/toolsrc/library/tools/vendors/mvl/arm/mvl5.0/montavista/pro/devkit/arm/v5t_le/bin/arm_v5t_le-:${TARGET_PREFIX}:g \
        Makefile

	oe_runmake KERNEL_PATH=${STAGING_KERNEL_DIR}   \
           KERNEL_SRC=${STAGING_KERNEL_DIR}    \
           KERNEL_VERSION=${KERNEL_VERSION}    \
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
