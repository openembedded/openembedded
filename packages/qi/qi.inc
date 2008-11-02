DESCRIPTION = "Qi bootloader w/ Openmoko GTA02 and GTA03 support"
LICENSE = "GPL"
SECTION = "bootloader"
PROVIDES = "virtual/bootloader"
LOCALVERSION = "gitr${SRCREV}"
PV = "0.0.0+${LOCALVERSION}"

EXTRA_OEMAKE = ""
PARALLEL_MAKE = ""
BUILD_BRANCH ?= "master"

QI_MACHINES = "s3c2442 s3c6410"

do_configure() {
	echo >config.mk
	#sed -i s,@,, Makefile
}

do_compile () {
	gccv=`${CC} -dumpversion`
	for mach in ${QI_MACHINES}
	do
		${MAKE} clean
		${MAKE} CPU=$mach \
			HOSTCC="${BUILD_CC}" \
			COMPILER_LIB_PATH="${CROSS_DIR}/lib/gcc/${TARGET_SYS}/$gccv/" \
			BUILD_BRANCH="master" \
			BUILD_HEAD="${LOCALVERSION}"
		cp -f image/qi-$mach* ${S}
	done
}

do_deploy () {
	install -d ${DEPLOY_DIR_IMAGE}
	for mach in ${QI_MACHINES}
	do
		cat qi-$mach-${BUILD_BRANCH}_${LOCALVERSION} >> qi-$mach-${BUILD_BRANCH}_${LOCALVERSION}.udfu
		install -m 0644 qi-$mach-${BUILD_BRANCH}_${LOCALVERSION}.udfu ${DEPLOY_DIR_IMAGE}/qi-$mach-${BUILD_BRANCH}-${PV}-${PR}.bin
        ln -sf ${DEPLOY_DIR_IMAGE}/qi-${mach}-${PV}-${PR}.bin ${DEPLOY_DIR_IMAGE}/qi-${mach}-${BUILD_BRANCH}-latest.bin
	done
}

do_deploy[dirs] = "${S}"
addtask deploy before do_package after do_install
addtask quilt before do_patch after do_unpack
addtask svnrev before do_patch after do_quilt
