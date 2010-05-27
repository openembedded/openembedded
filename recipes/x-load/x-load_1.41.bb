require x-load.inc

COMPATIBLE_MACHINE = "am3517-evm"

SRC_URI = "file://x-loader-03.00.00.01.tar.gz \
file://0013-board.c-print-boot-method-mmc-onenand-nand.patch \
file://0014-board.c-check-for-u-boot-on-mmc-on-all-configurati.patch \
file://0015-OMAP3EVM-Build-issue-fixed.patch \
file://0016-mmc-fix-infinite-loop-in-mmc_init_stream.patch \
file://0017-lib-board.c-add-missing-call-to-misc_init_r.patch \
file://0018-omap3evm-provide-missing-udelay-function.patch \
file://0019-lib-board.c-Specify-where-u-boot-is-being-loaded-fr.patch \
file://streen-fix.diff \
"

S = "${WORKDIR}/xloader-03.00.00.01"

PACKAGE_ARCH = "${MACHINE_ARCH}"
