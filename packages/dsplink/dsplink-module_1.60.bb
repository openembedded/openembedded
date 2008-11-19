# The tconf tool breaks if there is a '.' in your pwd
PR = "r3"
PE = "1"
PV = "160"

# Get dsplink tarball from TI website, place in sources and calculate
# md5sum
# Look for tarball at https://www-a.ti.com/downloads/sds_support/targetcontent/link/link_1_60/index.html

SRC_URI = "http://install.tarball.in.source.dir/dsplink_1_60.tar.gz \
		file://Makefile.dsplink \
		file://Makefile-dsplink-kbuild \
"

S = "${WORKDIR}/dsplink_1_60/dsplink"

# Needed for buildscripts
export DSPLINK="${S}"

inherit module
require ti-paths.inc

do_configure() {
    # Run perl script to create appropriate makefiles (v1.60 and up)
    perl config/bin/dsplinkcfg.pl --platform=${DSPLINKPLATFORM} --nodsp=1 --dspcfg_0=${DSPCFG} --dspos_0=DSPBIOS5XX  --gppos=${GPPOS} --comps=ponslrm
    
	mkdir -p ${S}/dsplink-kbuild-test
    cp ${WORKDIR}/Makefile-dsplink-kbuild  ${S}/dsplink-kbuild-test/Makefile
}

do_compile_prepend() {
	cd ${S}/dsplink-kbuild-test/
}

do_install() {
    install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
    cp ${S}/dsplink-kbuild-test/dsplinkk.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp/
}

INHIBIT_PACKAGE_STRIP = "1"



