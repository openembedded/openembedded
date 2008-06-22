DESCRIPTION = "Codec Engine for TI ARM/DSP processors"

DEPENDS = "virtual/kernel perl-native"
RDEPENDS = "update-modules"

inherit module

PR = "r1"
PV = "2.10"

# Get CE tarball from TI website, place in sources and calculate
# md5sum
# Look for tarball at https://www-a.ti.com/downloads/sds_support/targetcontent/CE/index.html

SRC_URI = "http://install.tarball.in.source.dir/codec_engine_2_10_01.tar.gz \
"

S = "${WORKDIR}/codec_engine_2_10_01"

do_compile() {
	cd ${S}/cetools/packages/ti/sdo/linuxutils/cmem
	sed -i \
		-e s:/db/toolsrc/library/vendors2005/mvl/arm/mvl4.0.1-root-new/montavista/pro/devkit/arm/v5t_le/bin/arm_v5t_le-:${TARGET_PREFIX}:g \
		-e s:/db/toolsrc/library/vendors2005/opensource/buildroot/10122007/build_arm/staging_dir/usr/bin/arm-linux-:${TARGET_PREFIX}:g \
		-e s:/db/toolsrc/library/vendors2005/mvl/arm/DaVinci-Linux-Rel_mvl401c/Linux:${STAGING_KERNEL_DIR}:g \
	Rules.make

	oe_runmake clean
	oe_runmake
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

