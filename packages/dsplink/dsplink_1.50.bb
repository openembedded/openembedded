DESCRIPTION = "DSP Link for TI ARM/DSP processors"

PR = "r0"

# Get dsplink tarball from TI website, place in sources and calculate
# md5sum
# Look for tarball at https://www-a.ti.com/downloads/sds_support/targetcontent/link/index.html

SRC_URI ="http://install.tarball.in.source.dir/dsplink_1_50.tar.gz \
file://CURRENTCFG.MK \
file://c64xx_5.xx_linux.mk \
file://davinci_mvlpro5.0.mk \
"

S = "${WORKDIR}/dsplink_1_50"

do_configure () {
	cp ${WORKDIR}/CURRENTCFG.MK ${S}/dsplink/config
	cp ${WORKDIR}/davinci_mvlpro5.0.mk ${S}/dsplink/make/Linux
	cp ${WORKDIR}/c64xx_5.xx_linux.mk ${S}/dsplink/make/DspBios
}

do_compile () {
	export DSPLINK=${S}/dsplink
	make -C ${S}/dsplink/gpp/src
}

