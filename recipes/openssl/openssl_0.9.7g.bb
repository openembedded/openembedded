inherit pkgconfig

require openssl.inc

PR = "r7"

SRC_URI += "file://debian.patch;patch=1 \
            file://armeb.patch;patch=1;pnum=0 \
            file://gnueabi-arm.patch;patch=1 \
            file://gnueabi-armeb.patch;patch=1 \
            file://uclibcgnueabi.patch;patch=1 \
            file://avr32.patch;patch=1;pnum=0"
