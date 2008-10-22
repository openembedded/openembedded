DESCRIPTION = "DSP Link for TI ARM/DSP processors"

DEPENDS = "virtual/kernel perl-native"
RDEPENDS_${PN}-module = "update-modules"
RRECOMMENDS_${PN} = "${PN}-module"

inherit module

S = "${WORKDIR}/dsplink_1_50/dsplink"

# Needed for buildscripts
export DSPLINK = "${S}"

require ti-paths.inc

DSPLINKPLATFORM ?= "Davinci"

DSPLINKPLATFORM_omap5912osk = "OMAP"
DSPLINKPLATFORM_beagleboard = "OMAP3530"
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
                   -Uarm                  \
                   -Wdeclaration-after-statement -Os -marm  -mabi=aapcs-linux"
KERNELARMFLAGS_armv6 = "-include linux/autoconf.h -c -iwithprefix include -Iinclude -Wall  -Wstrict-prototypes \
                   -Wno-trigraphs -fno-strict-aliasing -fno-common             \
                   -fno-omit-frame-pointer -mapcs -mno-sched-prolog            \
                   -mlittle-endian \
                   -D__LINUX_ARM_ARCH__=6 -march=armv6j -mtune=arm1136jf-s \
                   -Uarm                  \                   
                   -Wdeclaration-after-statement -Os -marm  -mabi=aapcs-linux"
KERNELARMFLAGS_armv7a = "-c -nostdinc -include $(BASE_OSINC)/linux/autoconf.h -isystem $(OSINC_PLATFORM)  -iwithprefix include -Iinclude -Wall  -Wstrict-prototypes \
                   -Wno-trigraphs -fno-strict-aliasing -fno-common             \
                   -fno-omit-frame-pointer -mapcs -mno-sched-prolog            \                                      
                   -mlittle-endian \
                   -D__LINUX_ARM_ARCH__=7 -march=armv7-a -mtune=cortex-a8 \
                   -Uarm                  \ 
                   -Wdeclaration-after-statement -Os -marm  -mabi=aapcs-linux \
                   -D__KERNEL__ -mno-thumb-interwork   -msoft-float -fno-optimize-sibling-calls -g  -fno-stack-protector -Wno-pointer-sign -g -DUSE_UDEV=1 -DOS_LINUX -DLINUX_KERNEL"

DSPFLAGS = "-q -pdr -pdv -pden -ml3 -mv64+ "

export DSPLINKPLATFORM 
export DSPLINKDSP
export DSPLINKSOC

do_configure () {

# Run perl script to create appropriate makefiles (v1.60 and up)
DSPLINK=${S} perl config/bin/dsplinkcfg.pl --platform=${DSPLINKPLATFORM} --nodsp=1 --dspcfg_0=OMAP3530SHMEM --dspos_0=DSPBIOS5XX  --gppos=OMAPLSP --comps=ponslrmc

}

PARALLEL_MAKE = ""

do_compile () {
	unset DISPLAY
	sed -i -e s:armv7a:armv7-a:g make/Linux/omap3530_2.6.mk || true

	# export various settings to override the defaults in the makefiles	
	export DSP_BASE_CGTOOLS=${TITOOLSDIR}/${TICGTOOLSDIR}
	export DSP_BASE_BIOS=${TITOOLSDIR}/${TIBIOSDIR}
	export DSP_BASE_RTDX=${TITOOLSDIR}/${TIBIOSDIR}/packages/ti/rtdx
	export GPPTOOL_DIR=${CROSS_DIR}
	export LINUXKERNEL_INSTALL_DIR=${STAGING_KERNEL_DIR}
	export LINK_INSTALL_DIR=${S}
	export VARIANT=${DSPLINKSOC}
	export PLATFORM=${DSPLINKPLATFORM}
	export BASE_TOOLCHAIN=${CROSS_DIR}
	export BASE_CGTOOLS=${BASE_TOOLCHAIN}/bin
	export OSINC_PLATFORM1=${CROSS_DIR}/lib/gcc/${TARGET_SYS}/$(${TARGET_PREFIX}gcc -dumpversion)/include
	export OSINC_TARGET=${BASE_TOOLCHAIN}/target/usr/include
	export ARCHIVER_AR=${TARGET_PREFIX}ar
	export BASE_SABIOS=${DSP_BASE_BIOS}
	
	make -e -f ${WORKDIR}/Makefile.dsplink
}

do_install () {
	install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
	cp ${S}/gpp/BUILD/EXPORT/RELEASE/dsplinkk.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/

	install -d ${D}/${bindir}
	install ${S}/gpp/BUILD/EXPORT/RELEASE/loopgpp           ${D}/${bindir}
	install ${S}/gpp/BUILD/EXPORT/RELEASE/messagegpp        ${D}/${bindir}
	install ${S}/gpp/BUILD/EXPORT/RELEASE/messagemultigpp   ${D}/${bindir}
	install ${S}/gpp/BUILD/EXPORT/RELEASE/mpcsxfergpp       ${D}/${bindir}
	install ${S}/gpp/BUILD/EXPORT/RELEASE/mplistgpp         ${D}/${bindir}
	install ${S}/gpp/BUILD/EXPORT/RELEASE/readwritegpp      ${D}/${bindir}
	install ${S}/gpp/BUILD/EXPORT/RELEASE/ringiogpp         ${D}/${bindir}
	install ${S}/gpp/BUILD/EXPORT/RELEASE/scalegpp          ${D}/${bindir}

	install -d ${D}/${datadir}/dsplink
	for i in $(find ${S}/dsp/BUILD/ -name "*.out") ; do
		install ${i}  ${D}/${datadir}/dsplink
	done	

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
FILES_${PN} = "${bindir}/* ${datadir}/dsplink/*"

INHIBIT_PACKAGE_STRIP = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}" 

