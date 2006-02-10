DESCRIPTION = "Bootloader firmware extractor for the h2200 iPAQ"
ALLOW_EMPTY = "1"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"
PR="r2"

pkg_postinst() {
#!/bin/sh
mkdir -p /lib/firmware
dd if=/dev/mtdblock0 of=/lib/firmware/h2200_bootloader.bin 2>/dev/null
}
