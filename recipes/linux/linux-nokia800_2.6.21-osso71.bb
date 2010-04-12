require linux-nokia800.inc
PR = "r5"

DEFAULT_PREFERENCE_nokia770 = "-1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.21.tar.bz2;name=kernel \
	   http://repository.maemo.org/pool/os2008/free/source/k/kernel-source-rx-34/kernel-source-rx-34_2.6.21.0-osso71.diff.gz;patch=1;name=ossopatch \
           ${RPSRC}/input_power-r7.patch;patch=1;name=rppatch24 \
	   file://suspend-button.patch;patch=1 \
           file://linux-2.6-limits.patch;patch=1 \
           file://1300-fix-gcc-4.3-false-modulo-optimization.patch.patch;patch=1 \
	   file://defconfig"

S = "${WORKDIR}/linux-2.6.21"

do_stage_append () {
	mkdir -p ${STAGING_KERNEL_DIR}/drivers/media/video/omap/
	cp -f drivers/media/video/omap/tcm825x.h ${STAGING_KERNEL_DIR}/drivers/media/video/omap/
}

SRC_URI[kernel.md5sum] = "1b515f588078dfa7f4bab2634bd17e80"
SRC_URI[kernel.sha256sum] = "f187b12d70e0a48ce81f0472dfe9504fb5f0f966be339ac9d57dd2b991a74942"
SRC_URI[ossopatch.md5sum] = "f2a893efdc2712b70ee8fbb65da2a70e"
SRC_URI[ossopatch.sha256sum] = "f219303e60f81b3cf6206b6c1851bd42069bd018ed18482ab04dded0b4339f8a"
SRC_URI[rppatch24.md5sum] = "25bbe0e1412dce7f36f54392872c673c"
SRC_URI[rppatch24.sha256sum] = "8526befd5b233a5911ccc6b6db4bba29ca3156db2828c11b5c696aa2e506c621"
