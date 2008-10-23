DESCRIPTION = "Codec Engine for TI ARM/DSP processors"

DEPENDS = "virtual/kernel perl-native"
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

export DSPLINK="${S}/cetools/packages/dsplink"

PARALLEL_MAKE = ""

do_configure () {
	# Run perl script to create appropriate makefiles (v1.60 and up)
	perl ${S}/cetools/packages/dsplink/config/bin/dsplinkcfg.pl --platform=${DSPLINKPLATFORM} --nodsp=1 --dspcfg_0=${DSPCFG} --dspos_0=DSPBIOS5XX  --gppos=${GPPOS} --comps=ponslrm
}

do_compile() {
    unset DISPLAY
    sed -i -e s:armv7a:armv7-a:g make/Linux/omap3530_2.6.mk || true

    # export various settings to override the defaults in the makefiles
    export DSP_BASE_CGTOOLS=${TITOOLSDIR}/${TICGTOOLSDIR}
    export DSP_BASE_BIOS=${TITOOLSDIR}/${TIBIOSDIR}
    export DSP_BASE_RTDX=${TITOOLSDIR}/${TIBIOSDIR}/packages/ti/rtdx
    export GPPTOOL_DIR=${CROSS_DIR}
    export LINUXKERNEL_INSTALL_DIR=${STAGING_KERNEL_DIR}
    export LINK_INSTALL_DIR=${DSPLINK}
    export VARIANT=${DSPLINKSOC}
    export PLATFORM=${DSPLINKPLATFORM}
    export BASE_TOOLCHAIN=${CROSS_DIR}
    export BASE_CGTOOLS=${BASE_TOOLCHAIN}/bin
    # 'OSINC_PLATFORM' is used in both the dsp and gpp sides...
    export OSINC_PLATFORM1=${CROSS_DIR}/lib/gcc/${TARGET_SYS}/$(${TARGET_PREFIX}gcc -dumpversion)/include
    export OSINC_TARGET=${BASE_TOOLCHAIN}/target/usr/include

    # 'ARCHIVER' is being used in the dsp side of the build as well as gpp
    export ARCHIVER_AR=${TARGET_PREFIX}ar
    export BASE_SABIOS=${DSP_BASE_BIOS}
   
    make -e -f ${WORKDIR}/Makefile.dsplink

	echo "MVTOOL_PREFIX=${TARGET_PREFIX}" > ${S}/Rules.make		
	echo "UCTOOL_PREFIX=${TARGET_PREFIX}" >> ${S}/Rules.make
	echo "LINUXKERNEL_INSTALL_DIR=${STAGING_KERNEL_DIR}"  >> ${S}/Rules.make

	# Build the cmem kernel module
	# We unset CFLAGS because kernel modules need different ones, this is basically a verbatim copy of kernel.bbclass and module-base.bbclass	
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS	
	cd ${S}/cetools/packages/ti/sdo/linuxutils/cmem

	oe_runmake clean
	# We probably don't need to build all 3, but atm it doesn't hurt us	
	oe_runmake KERNEL_PATH=${STAGING_KERNEL_DIR}   \
           KERNEL_SRC=${STAGING_KERNEL_DIR}    \
           KERNEL_VERSION=${KERNEL_VERSION}    \
           CC="${KERNEL_CC}" LD="${KERNEL_LD}" \
           AR="${KERNEL_AR}" \
           release
	oe_runmake KERNEL_PATH=${STAGING_KERNEL_DIR}   \
           KERNEL_SRC=${STAGING_KERNEL_DIR}    \
           KERNEL_VERSION=${KERNEL_VERSION}    \
           CC="${KERNEL_CC}" LD="${KERNEL_LD}" \
           AR="${KERNEL_AR}" \
           debug
	oe_runmake KERNEL_PATH=${STAGING_KERNEL_DIR}   \
           KERNEL_SRC=${STAGING_KERNEL_DIR}    \
           KERNEL_VERSION=${KERNEL_VERSION}    \
           CC="${KERNEL_CC}" LD="${KERNEL_LD}" \
           AR="${KERNEL_AR}" 

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
	
	cd ${S}/examples
	# export some more variable to point to external TI tools
	# information is duplicated between the js and make based tools
	export CE_INSTALL_DIR=${S}
	export XDC_INSTALL_DIR=${TIXDCTOOLSDIR}
	export BIOS_INSTALL_DIR=${TITOOLSDIR}/${TIBIOSDIR}
	# needed for configuro:
	export CGTOOLS_V5T="${CROSS_DIR}"
	export CC_V5T="bin/${TARGET_PREFIX}gcc"

	# Fix paths to arm crosstools, c6x codegen and x86 gcc
	# Also disable uclibc and x86 builds
    sed -i -e s:/db/toolsrc/library/tools/vendors/cs/arm/arm-2007q3:${CROSS_DIR}:g \
        -e s:/db/toolsrc/library/tools/vendors/ti/c6x/6.0.16/Linux:${TITOOLSDIR}/${TICGTOOLSDIR}:g \
        -e s:/db/toolsrc/library/tools/vendors/opensource/gcc/4.1.0/Linux/gcc-4.1.0-glibc-2.3.6/i686-unknown-linux-gnu:/usr:g \
        -e s:arm-none-linux-gnueabi-:${TARGET_PREFIX}:g \
        -e 's:true, // build for uC Linux:false,:g' \
        -e 's:true,  // build for PC Linux:false,:g' \ 
       ${S}/examples/user.bld

	# Fix path to c6x codegen
	sed -i -e s:/db/toolsrc/library/tools/vendors/ti/c6x/6.0.16/Linux:${TITOOLSDIR}/${TICGTOOLSDIR}:g \
	        xdcpaths.mak
	
	# Start building the CE examples: codecs, extensions, servers (codec bundles) and ARM side apps	
	# the DSP side uses CC to point to the c6x codegen, but would get the gcc tool
	unset CC
	# Make clean doesn't do what you'd expect, it only cleans stuff you've enabled, so some cruft remains	
	for i in codecs extensions servers apps ; do
		make -e -C ${S}/examples/ti/sdo/ce/examples/$i clean	
		make -e -C ${S}/examples/ti/sdo/ce/examples/$i
	done	

}


do_install() {
		install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
		cp ${S}/cetools/packages/ti/sdo/linuxutils/cmem/src/module/cmemk.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
		cp ${S}/cetools/packages/ti/bios/power/${DSPPOWERSOC}/lpm/*.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp || true
}

do_stage() {
    install -d ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/codecengine
    cp -pPr ${S}/* ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/codecengine/
}

INHIBIT_PACKAGE_STRIP = "1"

PACKAGES =+ "ti-cmemk-module"
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

PACKAGES =+ "ti-lpm-module"
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


FILES_${PN} = "${base_sbindir}"

PACKAGE_ARCH = "${MACHINE_ARCH}" 
