DESCRIPTION = "Miscellaneous files for the base system."
SECTION = "base"
PRIORITY = "optional"
PR = "r0"
LICENSE = "BSD"
PACKAGE_ARCH = "all"

SRC_URI = "http://ftp.de.debian.org/debian/pool/main/l/lsb/lsb_3.2-23.tar.gz"

FILES_${PN} = "/lib/lsb"

S = "${WORKDIR}/lsb-3.2"

do_compile () {
}

do_install () {
	install -d ${D}/lib/lsb
	install -m 755 init-functions ${D}/lib/lsb/
}
