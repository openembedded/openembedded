DESCRIPTION = "mpg321 is a Free replacement for mpg123, a very popular command-line mp3 player."
SECTION = "console/multimedia"
DEPENDS = "libmad libao"
LICENSE = "GPL"
AUTHOR = "Joe Drew <hoserhead@woot.net>"
HOMEPAGE = "http://mpg321.sourceforge.net/"

SRC_URI = "${SOURCEFORGE_MIRROR}/mpg321/mpg321-0.2.10.tar.gz \
file://libao.m4.patch;patch=1"

inherit autotools

