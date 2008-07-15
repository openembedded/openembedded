DESCRIPTION = "Codec Engine for TI ARM/DSP processors"

DEPENDS = "virtual/kernel perl-native"
RDEPENDS = "update-modules"

inherit module

PR = "r4"
PV = "2.10"

# Get CE tarball from TI website, place in sources and calculate
# md5sum
# Look for tarball at https://www-a.ti.com/downloads/sds_support/targetcontent/CE/index.html

SRC_URI = "http://install.tarball.in.source.dir/codec_engine_2_10_01.tar.gz \
"

S = "${WORKDIR}/codec_engine_2_10_01"

PARALLEL_MAKE = ""
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
}

do_install() {
		unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
		cd ${S}/cetools/packages/ti/sdo/linuxutils/cmem
		oe_runmake install
		install -d ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
		mv ${D}/cmemk.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/dsp
		install -d ${D}/${base_sbindir}
		cd ${D} ; mv apitest apitestd multi_process multi_processd translate translated ${D}/${base_sbindir}		

		install -d ${D}/${libdir}
		for i in ${S}/cetools/packages/ti/sdo/linuxutils/cmem/lib/*.a ; do
			install -m 0755 $i ${D}/${libdir}/
		done
}

do_stage() {
		install -d ${STAGING_LIBDIR}	
		for i in ${S}/cetools/packages/ti/sdo/linuxutils/cmem/lib/*.a ; do
			install -m 0755 $i ${STAGING_LIBDIR}/
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
