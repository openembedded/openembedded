SECTION = "console/utils"
SRC_URI = "ftp://ftp.info-zip.org/pub/infozip/src/unzip${PV}.tar.gz"
S = "${WORKDIR}/unzip-5.51"

LICENSE = "Info-ZIP"

do_compile() {
        make -f unix/Makefile generic
}

do_install() {
        make -f unix/Makefile install prefix=${D}${prefix}
}


