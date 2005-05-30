DESCRIPTION = "A (de)compression library for the ZIP format"
SECTION = "console/utils"
LICENSE = "Info-ZIP"

SRC_URI = "ftp://ftp.info-zip.org/pub/infozip/src/unzip${PV}.tar.gz"
S = "${WORKDIR}/unzip-5.52"

do_compile() {
        make -f unix/Makefile generic
}

do_install() {
        make -f unix/Makefile install prefix=${D}${prefix}
}


