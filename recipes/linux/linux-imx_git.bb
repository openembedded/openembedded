require linux.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-imx-git/${MACHINE}"

PR = "r1"

COMPATIBLE_MACHINE = "(chumby-falconwing|mx28evk)"

SRC_URI_chumby-falconwing = "git://opensource.freescale.com/pub/scm/imx/linux-2.6-imx.git;protocol=http;branch=imx_2.6.28 \
                             http://files.chumby.com/source/falconwing/build2913/oe-patch-freescale-kernel.patch;name=patch \
                             file://defconfig"
SRCREV_chumby-falconwing = "eee5a08306df7d9b1f23f463c9e9439e04293b57"
PV_chumby-falconwing = "2.6.28"
SRC_URI_chumby-falconwing[patch.md5sum] = "47fd149d78839e0d54239a3f5934eed1"
SRC_URI_chumby-falconwing[patch.sha256sum] = "4bf5efedef5ab6be0ce29b21b7d06bfe0cec2c33c5e3dea831b6b66e08a371ad"


SRC_URI_mx28evk = "git://opensource.freescale.com/pub/scm/imx/linux-2.6-imx.git;protocol=http;branch=imx_2.6.35_10.12.01 \
                   http://foss.doredevelopment.dk/mirrors/imx/imx-bootlets-src-${PV_imx_bootlets}.tar.gz;name=imx-bootlets \
                   file://defconfig \
                   file://${LOGO_SIZE}/logo_linux_clut224.ppm.bz2"
SRCREV_mx28evk = "cca29a03fc83751ed319df4b3c38ce2f4216ee0a"
SRC_URI[imx-bootlets.md5sum] = "cf0ab3822dca694b930a051501c1d0e4"
SRC_URI[imx-bootlets.sha256sum] = "63f6068ae36884adef4259bbb1fe2591755718f22c46d0a59d854883dfab1ffc"
PV_mx28evk = "2.6.35"
PV_imx_bootlets = "10.12.01"
DEPENDS_append_mx28 = " elftosb-native"

do_compile_prepend_mx28() {
	# We just build the bootlets here
	oe_runmake -C ${WORKDIR}/imx-bootlets-src-${PV_imx_bootlets} -e MAKEFLAGS= linux_prep boot_prep power_prep CC="${CC}" CFLAGS="${CFLAGS}" AR="${AR}" BOARD=iMX28_EVK ARCH=mx28
}

do_deploy_append_mx28 () {
	cd ${WORKDIR}/imx-bootlets-src-${PV_imx_bootlets}
	sed -i 's,[^ *]zImage.*;,\tzImage="'${S}/arch/arm/boot/zImage'";,' linux.bd
	sed -i 's,[^ *]zImage.*;,\tzImage="'${S}/arch/arm/boot/zImage'";,' linux_ivt.bd
	elftosb -z -c linux.bd -o imx28_linux.sb
	elftosb -z -f imx28 -c ./linux_ivt.bd -o imx28_ivt_linux.sb
	install -d ${DEPLOY_DIR_IMAGE}
	install -m 0644 ${WORKDIR}/imx-bootlets-src-${PV_imx_bootlets}/imx28*linux.sb ${DEPLOY_DIR_IMAGE}/
}

S = "${WORKDIR}/git"
