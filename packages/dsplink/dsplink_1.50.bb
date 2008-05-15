DESCRIPTION = "DSP Link for TI ARM/DSP processors"

DEPENDS = "virtual/kernel"

inherit module-base

PR = "r0"

# Get dsplink tarball from TI website, place in sources and calculate
# md5sum
# Look for tarball at https://www-a.ti.com/downloads/sds_support/targetcontent/link/index.html

SRC_URI = "http://install.tarball.in.source.dir/dsplink_1_50.tar.gz \
           file://CURRENTCFG.MK \
           file://c64xx_5.xx_linux.mk \
          file://davinci_mvlpro5.0.mk \
"

S = "${WORKDIR}/dsplink_1_50/dsplink"

# Needed for buildscripts
export DSPLINK = "${S}"

do_configure () {
	cp ${WORKDIR}/CURRENTCFG.MK ${S}/config
	cp ${WORKDIR}/davinci_mvlpro5.0.mk ${S}/make/Linux
	cp ${WORKDIR}/c64xx_5.xx_linux.mk ${S}/make/DspBios

	sed -i 	-e s:SED_ME_SOURCEDIR:${S}:g \
		-e s:SED_ME_GPPDISTRO:davinci_mvlpro5\.0:g \
		-e s:SED_ME_KERNELVERSION:${KERNEL_VERSION}:g \
		-e s:SED_ME_DSPDISTRO:davinci_mvlpro5\.0:g \
		-e s:SED_ME_PLATFORM:Davinci:g \
		${S}/config/CURRENTCFG.MK	

	sed -i	-e s:SED_ME_CROSS:${STAGING_INCDIR}:g \
		-e s:SED_ME_STAGINGDIR:${STAGING_DIR_TARGET}:g \
		-e s:SED_ME_TARGET_PREFIX:${TARGET_PREFIX}:g \
		${S}/make/Linux/davinci_mvlpro5.0.mk 

}

do_compile () {
	make -C ${S}/gpp/src
}

PACKAGE_ARCH = "${MACHINE_ARCH}" 

