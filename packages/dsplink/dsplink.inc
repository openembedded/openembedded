DESCRIPTION = "DSP Link for TI ARM/DSP processors"

DEPENDS = "virtual/kernel perl-native"
RDEPENDS_${PN}-module = "update-modules"
RRECOMMENDS_${PN} = "${PN}-module"

inherit module

S = "${WORKDIR}/dsplink_1_60/dsplink"

# Needed for buildscripts
export DSPLINK="${S}"

require ti-paths.inc

do_configure () {
	# Run perl script to create appropriate makefiles (v1.60 and up)
	perl config/bin/dsplinkcfg.pl --platform=${DSPLINKPLATFORM} --nodsp=1 --dspcfg_0=${DSPCFG} --dspos_0=DSPBIOS5XX  --gppos=${GPPOS} --comps=ponslrm
}

PARALLEL_MAKE = ""

do_compile () {
	unset DISPLAY
	sed -i -e s:armv7a:armv7-a:g make/Linux/omap3530_2.6.mk || true
    sed -i -e s:armv7a:armv7-a:g cetools/packages/dsplink/make/Linux/omap3530_2.6.mk || true 

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
}

do_install () {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
	cp ${S}/gpp/BUILD/EXPORT/RELEASE/dsplinkk.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/

	install -d ${D}/${bindir}
#	install ${S}/gpp/BUILD/EXPORT/RELEASE/loopgpp           ${D}/${bindir}
	install ${S}/gpp/BUILD/EXPORT/RELEASE/messagegpp        ${D}/${bindir}
	install ${S}/gpp/BUILD/EXPORT/RELEASE/messagemultigpp   ${D}/${bindir}
	install ${S}/gpp/BUILD/EXPORT/RELEASE/mpcsxfergpp       ${D}/${bindir}
	install ${S}/gpp/BUILD/EXPORT/RELEASE/mplistgpp         ${D}/${bindir}
	install ${S}/gpp/BUILD/EXPORT/RELEASE/readwritegpp      ${D}/${bindir}
	install ${S}/gpp/BUILD/EXPORT/RELEASE/ringiogpp         ${D}/${bindir}
	install ${S}/gpp/BUILD/EXPORT/RELEASE/scalegpp          ${D}/${bindir} || true

	install -d ${D}/${datadir}/dsplink
	for i in $(find ${S}/dsp/BUILD/ -name "*.out") ; do
		install ${i}  ${D}/${datadir}/dsplink
	done	

	install -d ${D}/${libdir}
	install -m 0755 ${S}/gpp/BUILD/EXPORT/RELEASE/dsplink.lib  ${D}/${libdir}
}


# Coded Engine and friends need a complete tree, so stage it all
do_stage() {
	install -d ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/dsplink
	cp -pPr ${S}/* ${STAGING_DIR}/${MULTIMACH_TARGET_SYS}/dsplink/ 
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

PACKAGES =+ "${PN}-module"
FILES_${PN}-module  = "${sysconfdir} /lib/modules"
FILES_${PN} = "${bindir}/* ${datadir}/dsplink/*"

INHIBIT_PACKAGE_STRIP = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}" 

