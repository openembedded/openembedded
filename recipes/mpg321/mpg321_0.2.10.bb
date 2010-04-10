DESCRIPTION = "mpg321 is a replacement for mpg123, a very popular command-line mp3 player."
SECTION = "console/multimedia"
DEPENDS = "libmad libao"
LICENSE = "GPL"
AUTHOR = "Joe Drew <hoserhead@woot.net>"
HOMEPAGE = "http://mpg321.sourceforge.net/"
RCONFLICTS_${PN} = "mpg123"
RREPLACES_${PN} = "mpg123"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/mpg321/mpg321-0.2.10.tar.gz \
           file://libao.m4.patch;patch=1"

inherit autotools

EXTRA_OECONF="--with-ao-includes=${STAGING_INCDIR} --with-ao-libraries=${STAGING_LIBDIR}"

SRC_URI[md5sum] = "bb403b35c2d25655d55f0f616b8f47bb"
SRC_URI[sha256sum] = "db0c299592b8f1f704f41bd3fc3a2bf138658108588d51af61638c551af1b0d4"
