DESCRIPTION = "Electronic book library"
HOMEPAGE = "http://www.sra.co.jp/people/m-kasahr/eb"
SECTION = "libs"
LICENSE = "GPL"
#DEPENDS = "zlib"

SRC_URI = "ftp://ftp.sra.co.jp/pub/misc/eb/eb-${PV}.tar.bz2"

inherit autotools

EXTRA_OECONF += " --with-pkgdocdir=${docdir}/eb"

do_stage () {
	autotools_stage_all
}

PACKAGES =+ "eb-utils"
FILES_eb-utils = "/usr/bin/*"

SRC_URI[md5sum] = "408bbe0f8ed45d341bc36cc4ee6184e7"
SRC_URI[sha256sum] = "4f5f71590eafa6c3599876806c8d655c3aeff5b2222643ff0ff41a6883ee5ea0"
