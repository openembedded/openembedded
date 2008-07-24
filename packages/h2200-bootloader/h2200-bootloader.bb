DESCRIPTION = "Bootloader firmware extractor for the h2200 iPAQ"
RRECOMMENDS_${PN} = "kernel-module-mtdblock"
ALLOW_EMPTY = "1"
PR = "r3"

COMPATIBLE_MACHINE = "h2200"
#it is a shell script, but lets protect the innocent some more
PACKAGE_ARCH = "h2200"

pkg_postinst() {
#!/bin/sh
mkdir -p /lib/firmware
modprobe mtdblock
dd if=/dev/mtdblock0 of=/lib/firmware/h2200_bootloader.bin 2>/dev/null
}
