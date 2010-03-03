DESCRIPTION = "File attempts to classify files depending \
on their contents and prints a description if a match is found."
SECTION = "console/utils"
LICENSE = "BSD-ADV"
DEPENDS = "file-native"
DEPENDS_virtclass-native = ""

INCPR = "r2"

SRC_URI = "ftp://ftp.astron.com/pub/file/file-${PV}.tar.gz"

inherit autotools

NATIVE_INSTALL_WORKS = "1"
BBCLASSEXTEND = "native"

FILES_${PN} += "${datadir}/misc/magic*"
