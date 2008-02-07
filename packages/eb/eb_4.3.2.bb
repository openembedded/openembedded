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
