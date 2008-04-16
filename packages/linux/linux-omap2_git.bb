require linux-omap.inc

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/linux-omap2-git/${MACHINE}"

SRCREV = "8eef374ecb0010acceda6571a46be131f1dc0b86"
PV = "2.6.24+2.6.25rc9-git${SRCREV}"
PR = "r3"


SRC_URI = "git://source.mvista.com/git/linux-omap-2.6.git;protocol=git \
           file://defconfig"

SRC_URI_append_beagleboard = " file://1-rearrange-omap3.patch;patch=1 \
                               file://2-update-omap3evm-kconfig.patch;patch=1 \
                               file://3-omap3evm-board.patch;patch=1 \
                               file://4-omap3evm-config.patch;patch=1 \
                               file://5-omap3evm-header.patch;patch=1 \
                               file://beagle-board-file.diff;patch=1 \
                               file://beagle-board-header.diff;patch=1 \
                               file://beagle-kconfig-makefile.diff;patch=1 \
			       file://add-beagle-sd-support.diff;patch=1 \	                             
"

COMPATIBLE_MACHINE = "omap2430sdp|omap2420h4|beagleboard"


S = "${WORKDIR}/git"
