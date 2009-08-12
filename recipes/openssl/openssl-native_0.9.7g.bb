inherit pkgconfig native

require openssl.inc

PR = "${INC_PR}.0"

SRC_URI += "file://debian.patch;patch=1 \
            file://armeb.patch;patch=1;pnum=0 \
            file://gnueabi-arm.patch;patch=1"

do_install() {
	:
}

PACKAGES = ""
