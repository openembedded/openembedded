SECTION = "kernel"
DESCRIPTION = "2.6 Linux kernel for the Amstrad Delta (E3)"
LICENSE = "GPLv2"

COMPATIBLE_MACHINE = "amsdelta"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.16.tar.bz2;name=kernel \
	http://www.muru.com/linux/omap/patches/patch-2.6.16-omap2.bz2;patch=1;name=omap2patch \
	http://the.earth.li/pub/e3/2.6.16/00-ams-delta-backlight.diff;patch=1;name=amspatch1 \
	http://the.earth.li/pub/e3/2.6.16/01-ams-delta-lcd.diff;patch=1;name=amspatch2 \
	http://the.earth.li/pub/e3/2.6.16/02-ams-delta-keypad.diff;patch=1;name=amspatch3 \
	http://the.earth.li/pub/e3/2.6.16/03-ams-delta-modem.diff;patch=1;name=amspatch4 \
	http://the.earth.li/pub/e3/2.6.16/04-omapfb-12bpp-support.diff;patch=1;name=amspatch5 \
	http://the.earth.li/pub/e3/2.6.16/05-ams-delta-nand.diff;patch=1;name=amspatch6 \
	http://the.earth.li/pub/e3/2.6.16/06-ams-delta-keyboard.diff;patch=1;name=amspatch7 \
	http://the.earth.li/pub/e3/2.6.16/08-ams-delta-sound.diff;patch=1;name=amspatch8 \
	file://defconfig"
S = "${WORKDIR}/linux-2.6.16"

inherit kernel

python __anonymous () {
    import re
    host = bb.data.getVar('HOST_SYS', d, 1)
    if not re.match('arm.*-linux', host):
        raise bb.parse.SkipPackage("incompatible with host %s" % host)
}

KERNEL_IMAGETYPE = "uImage"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
        oe_runmake oldconfig
}

SRC_URI[kernel.md5sum] = "9a91b2719949ff0856b40bc467fd47be"
SRC_URI[kernel.sha256sum] = "1200dcc7e60fcdaf68618dba991917a47e41e67099e8b22143976ec972e2cad7"
SRC_URI[omap2patch.md5sum] = "b8de4aa518292ad3aef913645898218a"
SRC_URI[omap2patch.sha256sum] = "34beecc0dd156267e8004fb79efea9bf97e1157ed597bdde1841c16def2e9195"
SRC_URI[amspatch1.md5sum] = "996c9e83682714aa5b2fa4587427b66a"
SRC_URI[amspatch1.sha256sum] = "7a0c4feb5a275857cafa94505f492507edc2cff0ad2f13fa9cfad38a6e2e5524"
SRC_URI[amspatch2.md5sum] = "bbab13fe7465398f16b4c39343db3a80"
SRC_URI[amspatch2.sha256sum] = "99e50c8d8701be0b5bdeec326d198d64e6d5433450bcafeacbe8a7d30275e08c"
SRC_URI[amspatch3.md5sum] = "533b4d91a68e440cf39865fb42459718"
SRC_URI[amspatch3.sha256sum] = "9661e786937967dcedf9ae66daffde858cd6d039d06afccfcfcd02a7599c3b3c"
SRC_URI[amspatch4.md5sum] = "81147a26a8ae68da25ca775d49090001"
SRC_URI[amspatch4.sha256sum] = "8f20b246ee1410ee870bc379152135aba7fab3617775884e20bd61adbca85249"
SRC_URI[amspatch5.md5sum] = "1e446e2583e83d880b01ff2052beccbf"
SRC_URI[amspatch5.sha256sum] = "b40c5a097129ce8a78d0948d811418a98bda6b4122e20db0e6c1fee9cedb93ca"
SRC_URI[amspatch6.md5sum] = "176b526a2a26affa4712a1133027e849"
SRC_URI[amspatch6.sha256sum] = "9b5f561842e53ea5b9ace31e89ad26780847149b170fbdc57eb3bc2de76518a5"
SRC_URI[amspatch7.md5sum] = "97072ddc1a19e809d0d90c295c22dad1"
SRC_URI[amspatch7.sha256sum] = "74878bd6e7416c721ff7821e0dd87fc56c756ecdff91469f5971278a6ff4f9b1"
SRC_URI[amspatch8.md5sum] = "db867f9960b909fd15fb8063e49f928a"
SRC_URI[amspatch8.sha256sum] = "dc0a85632c61d298fe6dfdd540c0ea62e1d90f7752a2b3b1d683fa3ad726c95c"

