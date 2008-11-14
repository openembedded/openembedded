require dsplink.inc
require lpm.inc
require cmemk.inc

DESCRIPTION = "Codec Engine for TI ARM/DSP processors"

DEPENDS = "virtual/kernel perl-native"
RDEPENDS = "update-modules"

inherit module

# tconf from xdctools dislikes '.' in pwd :/
PR = "r2"
PV = "221"

# Get CE tarball from TI website, place in sources and calculate
# md5sum
# Look for tarball at https://www-a.ti.com/downloads/sds_support/targetcontent/CE/index.html

SRC_URI = "http://install.tarball.in.source.dir/codec_engine_2_21.tar.gz \
           file://Makefile.dsplink \
"

S = "${WORKDIR}/codec_engine_2_21"

require ti-paths.inc

export DSPLINK="${S}/cetools/packages/dsplink"

PARALLEL_MAKE = ""

# the include files on top define do_compile for the submodules 
do_compile_append() {
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
