inherit pkgconfig native

require openssl.inc

# This flag can contain target options (e.g -mfpu=neon for armv7-a systems)
export FULL_OPTIMIZATION = " "
export BUILD_OPTIMIZATION = " "

PR = "r2"

SRC_URI += "file://debian.patch;patch=1 \
            file://armeb.patch;patch=1;pnum=0 \
            file://gnueabi-arm.patch;patch=1"

FILESPATH = "${@base_set_filespath( ['${FILE_DIRNAME}/openssl-${PV}', '${FILE_DIRNAME}/openssl', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"

do_install() {
	:
}

