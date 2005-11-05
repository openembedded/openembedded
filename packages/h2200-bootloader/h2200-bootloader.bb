DESCRIPTION = "Bootloader firmware extractor for the h2200 iPAQ"
RRECOMMENDS = "kernel-module-mtdblock kernel-module-hamcop-nand"
ALLOW_EMPTY = "1"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"


pkg_postinst() {
#!/bin/sh
modprobe mtdblock; mkdir -p /lib/firmware ; modprobe hamcop_nand ;  dd if=/dev/mtdblock0 of=/lib/firmware/hamcop_bootloader.bin
}
