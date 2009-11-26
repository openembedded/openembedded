require linux-libc-headers.inc

INHIBIT_DEFAULT_DEPS = "1"
DEPENDS += "unifdef-native"
PR = "r3"

#SRCREV = "3146b39c185f8a436d430132457e84fa1d8f8208"
SRCREV = "d01303a1035a39e445007c7522d89ad985c4153c"

SRC_URI = "git://sopc.et.ntust.edu.tw/git/linux-2.6.git;branch=test-nios2;protocol=http \
           file://procinfo.h \
           file://system.ptf \
           file://headless_hwselect.patch;patch=1;pnum=2 \
	  "

#           file://hardware.mk \
#           file://defconfig \

S = "${WORKDIR}/git"

#SRC_URI = "http://127.0.0.1/linux-nios2-2.6.28-git.tbz \
#           file://procinfo.h \
#           file://system.ptf"
#S = "${WORKDIR}/linux-2.6"

set_arch() {
	case ${TARGET_ARCH} in
		alpha*)   ARCH=alpha ;;
		arm*)     ARCH=arm ;;
		cris*)    ARCH=cris ;;
		hppa*)    ARCH=parisc ;;
		i*86*)    ARCH=i386 ;;
		ia64*)    ARCH=ia64 ;;
		mips*)    ARCH=mips ;;
		m68k*)    ARCH=m68k ;;
		powerpc*) ARCH=powerpc ;;
		s390*)    ARCH=s390 ;;
		sh*)      ARCH=sh ;;
		sparc64*) ARCH=sparc64 ;;
		sparc*)   ARCH=sparc ;;
		x86_64*)  ARCH=x86_64 ;;
	        avr32*)   ARCH=avr32 ;;
                bfin*)    ARCH=blackfin ;;
		nios2*)	  ARCH=nios2 ;;
	esac
}

do_configure() {
	set_arch
#	cp ../hardware.mk arch/nios2
	oe_runmake hwselect SYSPTF=../system.ptf CPU_SELECTION=1 MEM_SELECTION=2 ARCH=$ARCH
	oe_runmake allnoconfig ARCH=$ARCH
}

do_compile () {
}

do_install() {
	set_arch
	oe_runmake headers_install INSTALL_HDR_PATH=${D}${exec_prefix} ARCH=$ARCH
}

do_install_append_arm() {
	cp ${WORKDIR}/procinfo.h ${D}${includedir}/asm/
}

STAGE_TEMP="${WORKDIR}/temp-staging"

do_stage () {
	set_arch
	echo $ARCH
	rm -rf ${STAGE_TEMP}
	mkdir -p ${STAGE_TEMP}
	oe_runmake headers_install INSTALL_HDR_PATH=${STAGE_TEMP}${exec_prefix} ARCH=$ARCH
	if [ "$ARCH" = "arm" ]; then
		cp ${WORKDIR}/procinfo.h ${STAGE_TEMP}${includedir}/asm/
	fi
	install -d ${STAGING_INCDIR}
	rm -rf ${STAGING_INCDIR}/linux ${STAGING_INCDIR}/asm ${STAGING_INCDIR}/asm-generic
	cp -pfLR ${STAGE_TEMP}${includedir}/linux ${STAGING_INCDIR}/
	cp -pfLR ${STAGE_TEMP}${includedir}/asm ${STAGING_INCDIR}/
	cp -pfLR ${STAGE_TEMP}${includedir}/asm-generic ${STAGING_INCDIR}/
}
