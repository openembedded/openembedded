DESCRIPTION = "Codec Engine for TI ARM/DSP processors"

DEPENDS = "virtual/kernel perl-native"
RDEPENDS = "update-modules"

inherit module

PR = "r7"
PV = "2.10"

# Get CE tarball from TI website, place in sources and calculate
# md5sum
# Look for tarball at https://www-a.ti.com/downloads/sds_support/targetcontent/CE/index.html

SRC_URI = "http://install.tarball.in.source.dir/codec_engine_2_10_01.tar.gz \
           file://xdcpaths.mak \
           file://ticel-config \
          "

S = "${WORKDIR}/codec_engine_2_10_01"

# Path to the dir where the TI tools are unpacked
TITOOLSDIR ?= "/OE/TI"
# Path under TITOOLSDIR where dspbios is unpacked
TIBIOSDIR ?= "bios_5_32_03"
TIXDCTOOLSDIR ?= "${TIBIOSDIR}/xdctools"
# Path under TITOOLSDIR where the dsp toolchain is unpacked
TICGTOOLSDIR ?= "cg6x_6_1_2"

PARALLEL_MAKE = ""

do_configure() {
    cp ${WORKDIR}/xdcpaths.mak ${S}/examples/
    sed -i -e s:SEDME_TITOOLS_BASEPATH:${TITOOLSDIR}:g \
        -e s:SEDME_BIOSUNPACKDIR:${TITOOLSDIR}/${TIBIOSDIR}:g \
        -e 's:SEDME_S:${S}:g' \
        -e s:SEDME_XDCTOOLSUNPACKDIR:${TITOOLSDIR}/${TIXDCTOOLSDIR}:g \
        -e s:/db/toolsrc/library/tools/vendors/mvl/arm/mvl4.0-new/montavista/pro/devkit/arm/v5t_le:${CROSS_DIR}:g \
        -e s:bin/arm_v5t_le-gcc:bin/${TARGET_PREFIX}gcc:g \
        -e s:/db/toolsrc/library/tools/vendors/ti/c6x/6.0.16/Linux:${TITOOLSDIR}/${TICGTOOLSDIR}:g \
        ${S}/examples/xdcpaths.mak

    sed -i -e s:/db/toolsrc/library/tools/vendors/mvl/arm/mvl4.0-new/montavista/pro/devkit/arm/v5t_le:${CROSS_DIR}:g \
        -e s:/db/toolsrc/library/tools/vendors/ti/c6x/6.0.16/Linux:${TITOOLSDIR}/${TICGTOOLSDIR}:g \
        ${S}/examples/user.bld

    for cfg in ${S}/examples/ti/sdo/ce/examples/apps/image_copy/package/cfg/*/*cfg ; do
        sed -i -e s:arm_v5t_le-:${TAGET_PREFIX}:g $cfg
    done

	install -d ${S}/examples/ti/sdo/ce/examples/apps/speech/linuxonly/app/
    echo -n "${CFLAGS} -I${TITOOLSDIR}/${TIXDCTOOLSDIR}/packages -I${S}/packages -I${S}/cetools/packages" > ${S}/examples/ti/sdo/ce/examples/apps/speech/linuxonly/app/compiler.opt
}

do_compile() {
	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS	
	cd ${S}/cetools/packages/ti/sdo/linuxutils/cmem
	sed -i \
		-e s:/db/toolsrc/library/vendors2005/mvl/arm/mvl4.0.1-root-new/montavista/pro/devkit/arm/v5t_le/bin/arm_v5t_le-:${TARGET_PREFIX}:g \
		-e s:/db/toolsrc/library/vendors2005/opensource/buildroot/10122007/build_arm/staging_dir/usr/bin/arm-linux-:${TARGET_PREFIX}:g \
		-e s:/db/toolsrc/library/vendors2005/mvl/arm/DaVinci-Linux-Rel_mvl401c/Linux:${STAGING_KERNEL_DIR}:g \
		-e s:/opt/mv_pro_4.0/montavista/pro/devkit/arm/v5t_le/target/opt/dvevm:${D}:g \
	Rules.make

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

#	oe_runmake -C ${S}/examples/ti/sdo/ce/examples/apps

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
	
		sed -i -e s:SEDME_CFLAGS:"-I${TITOOLSDIR}/${TIBIOSDIR}/xdctools/packages -I${STAGING_INCDIR}/codec-engine/packages  -I${STAGING_INCDIR}/codec-engine/cetools/packages/":g \
		       -e s:SEDME_STAGINGLIBDIR:${STAGING_LIBDIR}:g \
		          ${WORKDIR}/ticel-config
		install -m 0755 ${WORKDIR}/ticel-config ${STAGING_BINDIR_CROSS}
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
