require dsplink.inc

DESCRIPTION = "Codec Engine for TI ARM/DSP processors"

DEPENDS = "virtual/kernel perl-native"
RDEPENDS = "update-modules"

inherit module

# tconf from xdctools dislikes '.' in pwd :/
PR = "r8"
PV = "221"

# Get CE tarball from TI website, place in sources and calculate
# md5sum
# Look for tarball at https://www-a.ti.com/downloads/sds_support/targetcontent/CE/index.html

SRC_URI = "http://install.tarball.in.source.dir/codec_engine_2_21.tar.gz \
           file://cmem-class-device-27-and-sched-include-fix.patch;patch=1 \
           file://dsplink-semaphore-27.patch;patch=1 \
           file://lpm-device-create-and-semaphore-include-fix.patch;patch=1 \
           file://Makefile.dsplink \
           file://Makefile-dsplink-kbuild \
           file://Makefile-dsplink-gpp \
           file://Makefile-dsplink-dsp \
"

S = "${WORKDIR}/codec_engine_2_21"

require ti-paths.inc

export DSPLINK="${S}/cetools/packages/dsplink"

PARALLEL_MAKE = ""

# the include files on top define do_compile for the submodules 
do_compile_append() {
	cd ${S}/examples

	# Fix paths to arm crosstools, c6x codegen and x86 gcc
	# Also disable uclibc and x86 builds
	sed -i -e s:/db/toolsrc/library/tools/vendors/cs/arm/arm-2007q3:${CROSS_DIR}:g \
        -e s:/db/toolsrc/library/tools/vendors/ti/c6x/6.0.16/Linux:${TITOOLSDIR}/${TICGTOOLSDIR}:g \
        -e s:/db/toolsrc/library/tools/vendors/opensource/gcc/4.1.0/Linux/gcc-4.1.0-glibc-2.3.6/i686-unknown-linux-gnu:/usr:g \
        -e s:arm-none-linux-gnueabi-:${TARGET_PREFIX}:g \
        -e 's:true, // build for uC Linux:false,:g' \
        -e 's:true,  // build for PC Linux:false,:g' \
        ${S}/examples/user.bld

        # For now, remove all targets, except dm6446 and omap3530
        sed -i \
        -e '/evmDM357/d' \
        -e '/evmDM6467/d' \
        -e '/evmDM355/d' \
        -e '/evmDM6437/d' \
        -e '/evmDM648/d' \
        -e '/sdp3430/d' \
        -e '/evm2530/d' \
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


do_stage_append() {
	install -d ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/codecengine
    cp -pPrf ${S}/* ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/codecengine/
	ln -sf ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/codecengine/packages/ti/sdo/ce ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/codecengine/cetools/packages/ti/sdo/
}

INHIBIT_PACKAGE_STRIP = "1"

FILES_${PN} = "${base_sbindir}"

PACKAGE_ARCH = "${MACHINE_ARCH}" 
