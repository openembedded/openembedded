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

SRC_URI[src.md5sum] = "991615f73338a571b6a1be7d74906934"
SRC_URI[src.sha256sum] = "e7e1a287141dd1be7f4b4fedd54ec29fa904655ed76a13ac87ae69a3fc76b062"
