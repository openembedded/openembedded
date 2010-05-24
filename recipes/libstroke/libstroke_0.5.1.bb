DESCRIPTION = "LibStroke - a stroke translation library"
LICENSE = "GPL"
SECTION = "x11"
PRIORITY = "optional"
#DEPENDS = "virtual/libx11 libxau libxdmcp"
DEPENDS = "virtual/libx11"

SRC_URI = "http://www.etla.net/libstroke/${P}.tar.gz \
	file://configure.in.patch;apply=yes \
	file://libstroke-Makefile.am.patch;apply=yes \
	file://tests-Makefile.am.patch;apply=yes \
	"
#	file://Makefile.am.patch;apply=yes \
#	file://libgstroke-Makefile.am.patch;apply=yes \

inherit autotools pkgconfig

do_stage () {
	autotools_stage_all
}

SRC_URI[md5sum] = "51b9a4e309ac15cfcab96191eed03cb2"
SRC_URI[sha256sum] = "0da9f5fde66feaf6697ba069baced8fb3772c3ddc609f39861f92788f5c7772d"
