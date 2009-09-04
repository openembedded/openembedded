DESCRIPTION = "DSP Link for TI ARM/DSP processors"

DEPENDS = "virtual/kernel perl-native"

inherit module

do_configure () {
	# Clean up stale binaries
	find ${S} -name "*.ko" -exec rm {} \; || true
	find ${S} -name "*.o" -exec rm {} \; || true

	# Run perl script to create appropriate makefiles (v1.60 and up)
	(
	cd ${DSPLINK}
	perl config/bin/dsplinkcfg.pl --platform=${DSPLINKPLATFORM} --nodsp=1 --dspcfg_0=${DSPCFG} --dspos_0=DSPBIOS5XX  --gppos=${GPPOS} --comps=ponslrm
	)
}

do_compile () {
	unset DISPLAY
	sed -i -e s:armv7a:armv7-a:g ${DSPLINK}/make/Linux/omap3530_2.6.mk

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
	
    #dsplinkk.ko bits
	if [ ! -d ${DSPLINK}/gpp/BUILD/EXPORT/RELEASE ] ; then 
		install -d ${DSPLINK}/gpp/BUILD/EXPORT/RELEASE
	fi

	cp ${WORKDIR}/Makefile-dsplink-gpp ${DSPLINK}/gpp/BUILD/EXPORT/RELEASE/Makefile
	cd ${DSPLINK}/gpp/BUILD/EXPORT/RELEASE/

	unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	export KDIR=${STAGING_KERNEL_DIR}

	make -e driver
	make -e library
	make -e samples

	make -e -f ${WORKDIR}/Makefile-dsplink-dsp
	cp -a * ${DSPLINK}/gpp/export/BIN/Linux/${DSPLINKPLATFORM}/RELEASE
}

do_install () {
    #driver - kernel module
	install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
	cp ${DSPLINK}/gpp/BUILD/EXPORT/RELEASE/dsplinkk.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/ 

    #library
	install -d ${D}/${libdir}
	install -m 0755 ${DSPLINK}/gpp/BUILD/EXPORT/RELEASE/dsplink.lib  ${D}/${libdir}

    #sample apps
	install -d ${D}/${datadir}/ti-dsplink
	install ${DSPLINK}/gpp/BUILD/EXPORT/RELEASE/*gpp ${D}/${datadir}/ti-dsplink || true
	for i in $(find ${DSPLINK}/dsp/BUILD/ -name "*.out") ; do
		install ${i} ${D}/${datadir}/ti-dsplink
	done
}

# Codec Engine and friends need a complete tree, so stage it all
do_stage() {
	install -d ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/${PN}
	cp -pPrf ${S}/* ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/${PN}/ 
}

PACKAGES =+ "ti-dsplink-module ti-dsplink-apps"
FILES_ti-dsplink-module  = "/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/dsplinkk.ko"
FILES_ti-dsplink-apps = "${datadir}/ti-dsplink/* ${libdir}/dsplink.lib"

pkg_postinst_ti-dsplink-module () {
	if [ -n "$D" ]; then
		exit 1
	fi
	depmod -a
	update-modules || true
}

pkg_postrm_ti-dsplink-module () {
	update-modules || true
}

INHIBIT_PACKAGE_STRIP = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

#legacy upgrade helpers
RPROVIDES_ti-dsplink-module += "dsplink-module"
RREPLACES_ti-dsplink-module += "dsplink-module"
RPROVIDES_ti-dsplink-apps += "dsplink-apps"
RREPLACES_ti_dsplink-apps += "dsplink-apps"

#add run-time dependencies - note for kernel module we can only use RRECOMMENDS, since modules might be built into the kernel
RRECOMMENDS_ti-dsplink-apps += "ti-dsplink-module"

