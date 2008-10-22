DESCRIPTION = "Codec Engine for TI ARM/DSP processors"

DEPENDS = "virtual/kernel perl-native"
RDEPENDS = "update-modules"

inherit module

# tconf from xdctools dislikes '.' in pwd :/
PR = "r0"
PV = "221"

# Get CE tarball from TI website, place in sources and calculate
# md5sum
# Look for tarball at https://www-a.ti.com/downloads/sds_support/targetcontent/CE/index.html

SRC_URI = "http://install.tarball.in.source.dir/codec_engine_2_21_00_06.tar.gz \
          "

S = "${WORKDIR}/codec_engine_2_21_00_06"

require ti-paths.inc

PARALLEL_MAKE = ""
do_compile() {
	echo "MVTOOL_PREFIX=${TARGET_PREFIX}" > ${S}/Rules.make		
	echo "UCTOOL_PREFIX=${TARGET_PREFIX}" >> ${S}/Rules.make
	echo "LINUXKERNEL_INSTALL_DIR=${STAGING_KERNEL_DIR}"  >> ${S}/Rules.make

	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS	
	cd ${S}/cetools/packages/ti/sdo/linuxutils/cmem

	oe_runmake clean
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

	cd ${S}/cetools/packages/ti/bios/power
	if ! [ -e omap3530 ] ; then tar xf ti_bios_power,omap3530_bld.tar ; fi
   	cd omap3530/lpm 
	
	sed -i -e s:/db/toolsrc/library/tools/vendors/mvl/arm/omap3/OMAP35x_SDK_0.9.7/src/linux/kernel_org/2.6_kernel:${STAGING_KERNEL_DIR}:g \
           -e s:/db/toolsrc/library/tools/vendors/cs/arm/arm-2007q3/bin/arm-none-linux-gnueabi-:${TARGET_PREFIX}:g \
           -e s:/db/atree/library/trees/power/power-d02x/imports:${STAGING_DIR_TARGET}:g \
        Makefile

	oe_runmake KERNEL_PATH=${STAGING_KERNEL_DIR}   \
           KERNEL_SRC=${STAGING_KERNEL_DIR}    \
           KERNEL_VERSION=${KERNEL_VERSION}    \
           CC="${KERNEL_CC}" LD="${KERNEL_LD}" \
           AR="${KERNEL_AR}"
	
	cd ${S}/examples
	export CE_INSTALL_DIR=${S}
	export XDC_INSTALL_DIR=${TIXDCTOOLSDIR}
	export BIOS_INSTALL_DIR=${TITOOLSDIR}/${TIBIOSDIR}

    sed -i -e s:/db/toolsrc/library/tools/vendors/cs/arm/arm-2007q3:${CROSS_DIR}:g \
        -e s:/db/toolsrc/library/tools/vendors/ti/c6x/6.0.16/Linux:${TITOOLSDIR}/${TICGTOOLSDIR}:g \
        -e s:/db/toolsrc/library/tools/vendors/opensource/gcc/4.1.0/Linux/gcc-4.1.0-glibc-2.3.6/i686-unknown-linux-gnu:/usr:g \
        -e s:arm-none-linux-gnueabi-:${TARGET_PREFIX}:g \
        -e 's:true, // build for uC Linux:false,:g' \ 
       ${S}/examples/user.bld

	sed -i -e s:/db/toolsrc/library/tools/vendors/ti/c6x/6.0.16/Linux:${TITOOLSDIR}/${TICGTOOLSDIR}:g \
	        xdcpaths.mak

	for i in codecs extensions servers apps ; do
		make -e -C ${S}/examples/ti/sdo/ce/examples/$i clean	
		make -e -C ${S}/examples/ti/sdo/ce/examples/$i
	done	

}

export DSPLIBS = "${S}/packages/ti/sdo/ce/utils/trace/lib/*.a* \
                  ${S}/packages/ti/sdo/ce/bioslog/lib/*.a* \
                  ${S}/packages/ti/sdo/ce/video/lib/*.a* \
                  ${S}/packages/ti/sdo/ce/audio/lib/*.a* \
                  ${S}/packages/ti/sdo/ce/speech/lib/*.a* \
                  ${S}/packages/ti/sdo/ce/lib/*.a* \
                  ${S}/packages/ti/sdo/ce/alg/lib/*.a* \
                  ${S}/cetools/packages/ti/sdo/fc/dman3/*.a* \
                  ${S}/cetools/packages/ti/sdo/fc/acpy3/*.a* \
		          ${S}/packages/ti/sdo/ce/osal/linux/lib/osal_linux_470.a* \ 
                  ${S}/packages/ti/sdo/ce/utils/xdm/lib/*.a* \
                  ${S}/cetools/packages/ti/sdo/utils/trace/lib/*.a* \
                 "

do_install() {
		unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
		cd ${S}/cetools/packages/ti/sdo/linuxutils/cmem
		oe_runmake install
		install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
		mv ${D}/cmemk.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
		install -d ${D}/${base_sbindir}
		cd ${D} ; mv apitest apitestd multi_process multi_processd translate translated ${D}/${base_sbindir}		


		install -d ${D}/${libdir}
		for i in ${DSPLIBS}; do
			install -m 0755 $i ${D}/${libdir}/ || true
		done
        install -m 0755 ${S}/cetools/packages/ti/sdo/linuxutils/cmem/lib/*.a ${D}/${libdir}
}

do_stage() {
		install -d ${STAGING_LIBDIR}	
		for i in ${DSPLIBS} ; do
			install -m 0755 $i ${STAGING_LIBDIR}/ 
			ln -sf ${STAGING_LIBDIR}/$(basename $i | awk -F. '{print $1}').a470MV  ${STAGING_LIBDIR}/$(basename $i | awk -F. '{print $1}').a || true 
		done

        install -m 0755 ${S}/cetools/packages/ti/sdo/linuxutils/cmem/lib/*.a ${STAGING_LIBDIR}/

		install -d ${STAGING_INCDIR}/codec-engine}
		
		for header in $(find ${S}/cetools/packages/ -name "*.h") ; do
			install -d ${STAGING_INCDIR}/codec-engine/$(dirname $header | sed s:${S}::g)
			cp -pPr  $header ${STAGING_INCDIR}/codec-engine/$(echo $header | sed s:${S}::g)
		done
	
		for header in $(find ${S}/packages/ -name "*.h") ; do
			install -d ${STAGING_INCDIR}/codec-engine/$(dirname $header | sed s:${S}::g)
			cp -pPr  $header ${STAGING_INCDIR}/codec-engine/$(echo $header | sed s:${S}::g)
		done
	
}

pkg_postinst_${PN}-module () {
		if [ -n "$D" ]; then        
                exit 1
        fi
        depmod -a
        update-modules || true
}

pkg_postrm_${PN}-module () {
        update-modules || true
}

PACKAGES =+ "dsplink-cmemk-module"
FILES_dsplink-cmemk-module = "${sysconfdir} /lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/*ko"
INHIBIT_PACKAGE_STRIP = "1"

FILES_${PN} = "${base_sbindir}"

PACKAGE_ARCH = "${MACHINE_ARCH}" 
