DESCRIPTION = "DSP Link for TI ARM/DSP processors"

DEPENDS = "virtual/kernel perl-native"
RDEPENDS = "update-modules"

inherit module

S = "${WORKDIR}/dsplink_1_50/dsplink"

# Needed for buildscripts
export DSPLINK = "${S}"

DSPLINKPLATFORM ?= "Davinci"

DSPLINKPLATFORM_omap5912osk = "Omap"
DSPLINKPLATFORM_beagleboard = "Omap"
DSPLINKPLATFORM_davinci-sffsdr = "Davinci"
DSPLINKPLATFORM_davinci-dvevm = "Davinci"

DSPLINKDSP ?= "C64XX"

export DSPLINKPLATFORM 
export DSPLINKDSP

do_configure () {
	cp ${WORKDIR}/CURRENTCFG.MK ${S}/config
	cp ${WORKDIR}/davinci_mvlpro5.0.mk ${S}/make/Linux
	cp ${WORKDIR}/c64xx_5.xx_linux.mk ${S}/make/DspBios

	sed -i 	-e s:SED_ME_SOURCEDIR:${S}:g \
		-e s:SED_ME_GPPDISTRO:davinci_mvlpro5\.0:g \
		-e s:SED_ME_KERNELVERSION:${KERNEL_VERSION}:g \
		-e s:SED_ME_DSPDISTRO:davinci_mvlpro5\.0:g \
		-e s:SED_ME_PLATFORM:${DSPLINKPLATFORM}:g \
		-e s:SED_ME_DSP:${DSPLINKDSP}:g \
		${S}/config/CURRENTCFG.MK	

	sed -i	-e s:SED_ME_CROSS:${STAGING_INCDIR}:g \
		-e s:SED_ME_STAGINGDIR:${STAGING_DIR_TARGET}:g \
		-e s:SED_ME_TARGET_PREFIX:${TARGET_PREFIX}:g \
		-e s:SED_ME_KERNELDIR:${STAGING_KERNEL_DIR}:g \	
		${S}/make/Linux/davinci_mvlpro5.0.mk 

}

PARALLEL_MAKE = ""

do_compile () {
	ln -sf ${S}/gpp/src/api/*h ${S}/gpp/inc/
	ln -sf ${S}/gpp/src/pmgr/Linux/2.6.18 ${S}/gpp/src/pmgr/Linux/${KERNEL_VERSION}
	ln -sf ${S}/gpp/src/api/Linux/2.6.18 ${S}/gpp/src/api/Linux/${KERNEL_VERSION}
	ln -sf ${S}/gpp/src/osal/Linux/2.6.18 ${S}/gpp/src/osal/Linux/${KERNEL_VERSION}
	ln -sf ${S}/gpp/src/pmgr/Linux/drv_pmgr.h ${S}/gpp/inc/drv_pmgr.h
	ln -sf ${S}/gpp/src/pmgr/pmgr_proc.h ${S}/gpp/inc/pmgr_proc.h

	unset DISPLAY
 
	oe_runmake -C ${S}/gpp/src all targets
	oe_runmake -C ${S}/gpp/src/samples
}

do_install () {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
	cp ${S}/gpp/BUILD/EXPORT/RELEASE/dsplinkk.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/
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

PACKAGE_ARCH = "${MACHINE_ARCH}" 

