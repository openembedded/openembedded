DESCRIPTION = "Bootloader firmware extractor for the h2200 iPAQ"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"
PR="r3"

PACKAGES = "${PN}"
ALLOW_EMPTY_${PN} = "1"

pkg_postinst_${PN} () {
#!/bin/sh
mkdir -p /lib/firmware
dd if=/dev/mtdblock0 of=/lib/firmware/h2200_bootloader.bin 2>/dev/null
}
