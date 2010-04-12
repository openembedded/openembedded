inherit pkgconfig native

require openssl.inc

# This flag can contain target options (e.g -mfpu=neon for armv7-a systems)
export FULL_OPTIMIZATION = " "
export BUILD_OPTIMIZATION = " "

PR = "${INC_PR}.0"

SRC_URI += "file://debian.patch;patch=1 \
            file://armeb.patch;patch=1;pnum=0 \
            file://gnueabi-arm.patch;patch=1"

do_install() {
	:
}

PACKAGES = ""

SRC_URI[src.md5sum] = "74a4d1b87e1e6e1ec95dbe58cb4c5b9a"
SRC_URI[src.sha256sum] = "c98b9703887e2dda6217b91405d0d94883f7c67e205fc4d7a81bb690d2e10572"
