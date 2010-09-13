require linux.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-imx-git/${MACHINE}"

SRCREV = "eee5a08306df7d9b1f23f463c9e9439e04293b57"

PV = "2.6.28"
PR = "r0"

SRC_URI = "git://opensource.freescale.com/pub/scm/imx/linux-2.6-imx.git;protocol=http;branch=imx_2.6.28 \
           file://defconfig \
"

SRC_URI_append_chumby-falconwing = "http://files.chumby.com/source/falconwing/build2913/oe-patch-freescale-kernel.patch;name=patch"

COMPATIBLE_MACHINE = "chumby-falconwing"

S = "${WORKDIR}/git"

SRC_URI[patch.md5sum] = "47fd149d78839e0d54239a3f5934eed1"
SRC_URI[patch.sha256sum] = "4bf5efedef5ab6be0ce29b21b7d06bfe0cec2c33c5e3dea831b6b66e08a371ad"
