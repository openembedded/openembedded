DESCRIPTION = "DSP Link for TI ARM/DSP processors"

DEPENDS = "virtual/kernel perl-native"
RDEPENDS_${PN}-module = "update-modules"
RRECOMMENDS_${PN} = "${PN}-module"

inherit module

S = "${WORKDIR}/dsplink_1_50/dsplink"

# Needed for buildscripts
export DSPLINK = "${S}"

DSPLINKPLATFORM ?= "Davinci"

DSPLINKPLATFORM_omap5912osk = "OMAP"
DSPLINKPLATFORM_beagleboard = "OMAP"
DSPLINKPLATFORM_davinci-sffsdr = "Davinci"
DSPLINKPLATFORM_davinci-dvevm = "Davinci"

DSPLINKDSP ?= "C64XX"
DSPLINKSOC ?= "DM6446"

DSPLINKSOC_beagleboard = "3530"


USERARMFLAGS = "${TARGET_CC_ARCH}"
KERNELARMFLAGS = "-include linux/autoconf.h -c -iwithprefix include -Iinclude -Wall  -Wstrict-prototypes \
                   -Wno-trigraphs -fno-strict-aliasing -fno-common             \
                   -fno-omit-frame-pointer -mapcs -mno-sched-prolog            \
                   -mlittle-endian \
                   -D__LINUX_ARM_ARCH__=5 -march=armv5t -mtune=arm9tdmi \
                   -msoft-float -Uarm -mapcs                  \
                   -Wdeclaration-after-statement -Os -marm  -mabi=aapcs-linux"
KERNELARMFLAGS_armv6 = "-include linux/autoconf.h -c -iwithprefix include -Iinclude -Wall  -Wstrict-prototypes \
                   -Wno-trigraphs -fno-strict-aliasing -fno-common             \
                   -fno-omit-frame-pointer -mapcs -mno-sched-prolog            \
                   -mlittle-endian \
                   -D__LINUX_ARM_ARCH__=6 -march=armv6j -mtune=arm1136jf-s \
                   -msoft-float -Uarm -mapcs                  \                   
                   -Wdeclaration-after-statement -Os -marm  -mabi=aapcs-linux"
KERNELARMFLAGS_armv7a = "-c -nostdinc -include $(BASE_OSINC)/linux/autoconf.h -isystem $(OSINC_PLATFORM)  -iwithprefix include -Iinclude -Wall  -Wstrict-prototypes \
                   -Wno-trigraphs -fno-strict-aliasing -fno-common             \
                   -fno-omit-frame-pointer -mapcs -mno-sched-prolog            \                                      
                   -mlittle-endian \
                   -D__LINUX_ARM_ARCH__=7 -march=armv7-a -mtune=cortex-a8 \
                   -msoft-float -Uarm -mapcs                  \ 
                   -Wdeclaration-after-statement -Os -marm  -mabi=aapcs-linux \
                   -D__KERNEL__ -mno-thumb-interwork   -msoft-float -fno-optimize-sibling-calls -g  -fno-stack-protector -Wno-pointer-sign -g -DUSE_UDEV=1 -DOS_LINUX -DLINUX_KERNEL"

export DSPLINKPLATFORM 
export DSPLINKDSP

do_configure () {
	cp ${WORKDIR}/CURRENTCFG.MK ${S}/config
	cp ${WORKDIR}/openembedded.mk ${S}/make/Linux
	cp ${WORKDIR}/c64xx_5.xx_linux.mk ${S}/make/DspBios

	sed -i 	-e s:SED_ME_SOURCEDIR:${S}:g \
		-e s:SED_ME_GPPDISTRO:openembedded:g \
		-e s:SED_ME_KERNELVERSION:${KERNEL_VERSION}:g \
		-e s:SED_ME_DSPDISTRO:openembedded:g \
		-e s:SED_ME_PLATFORM:${DSPLINKPLATFORM}:g \
		-e s:SED_ME_DSP:${DSPLINKDSP}:g \
		-e s:SED_ME_SOC:${DSPLINKSOC}:g \	
    	${S}/config/CURRENTCFG.MK	

	sed -i	-e s:SED_ME_CROSS:${STAGING_INCDIR}:g \
		-e s:SED_ME_STAGINGDIR:${STAGING_DIR_TARGET}:g \
		-e s:SED_ME_TARGET_PREFIX:${TARGET_PREFIX}:g \
		-e s:SED_ME_KERNELDIR:${STAGING_KERNEL_DIR}:g \
		-e 's:SEDME_KERNEL_ARMFLAGS:${KERNELARMFLAGS}:g' \
		-e 's:SEDME_USER_ARMFLAGS:${USERARMFLAGS}:g' \
		${S}/make/Linux/openembedded.mk 

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
	
	sed -i -e 's:gcc:gcc${KERNEL_CCSUFFIX}:' ${S}/make/Linux/openembedded.mk
	oe_runmake CC="${KERNEL_CC}" LD="${KERNEL_LD}" -C ${S}/gpp/src all targets
	
	sed -i -e 's:gcc${KERNEL_CCSUFFIX}:gcc:' ${S}/make/Linux/openembedded.mk
	oe_runmake -C ${S}/gpp/src/samples
}

do_install () {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
	cp ${S}/gpp/BUILD/EXPORT/RELEASE/dsplinkk.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/

	install -d ${D}/${bindir}
	install ${S}/gpp/BUILD/EXPORT/RELEASE/mpcsxfergpp ${D}/${bindir}
	install ${S}/gpp/BUILD/EXPORT/RELEASE/ringiogpp   ${D}/${bindir}

	install -d ${D}/${libdir}
	install -m 0755 ${S}/gpp/BUILD/EXPORT/RELEASE/dsplink.lib  ${D}/${libdir}
}


do_stage() {
	install -d ${STAGING_LIBDIR}
	install -m 0755 ${S}/gpp/BUILD/EXPORT/RELEASE/dsplink.lib ${STAGING_LIBDIR}/
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
FILES_${PN} = "${bindir}/mpcsxfergpp ${bindir}/ringiogpp"
INHIBIT_PACKAGE_STRIP = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}" 

