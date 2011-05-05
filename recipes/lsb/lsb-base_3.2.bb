DESCRIPTION = "Miscellaneous files for the base system."
SECTION = "base"
PRIORITY = "optional"
PR = "r0"
LICENSE = "BSD"
PACKAGE_ARCH = "all"

SRC_URI = "http://ftp.de.debian.org/debian/pool/main/l/lsb/lsb_3.2-27.tar.gz"

FILES_${PN} = "/lib/lsb"

S = "${WORKDIR}/lsb-3.2"

do_compile () {
}

do_install () {
	install -d ${D}/lib/lsb
	install -m 755 init-functions ${D}/lib/lsb/
}

SRC_URI[md5sum] = "eb22ef00c02d60e7cd5b9070c8fadd98"
SRC_URI[sha256sum] = "15d7e2ba0a54c809442952c676f7b30d00a9a0207a3ddcc4ae7aaea830eccc08"
