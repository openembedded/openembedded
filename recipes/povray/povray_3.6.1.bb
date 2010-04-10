DESCRIPTION = "The Persistence of Vision Raytracer is a high-quality, totally free tool for creating stunning three-dimensional graphics. "
HOMEPAGE = "http://www.povray.org"
SECTION = "console/graphics"
#Make this a weak assigment to allow branding of the povray binary
LICENSE = "povray"
DEPENDS = "virtual/libx11 zlib jpeg libpng tiff"
RDEPENDS = ""

PR = "r2"

#We apply a patch that subverts the checks for jpeg, zlib, png and tiff because we know OE has the required versions, but it is still a hack.
SRC_URI = "http://www.povray.org/redirect/www.povray.org/ftp/pub/povray/Official/Unix/${P}.tar.bz2 \
	   file://configure-cross-hack.patch;patch=1"

inherit autotools pkgconfig

PARALLEL_MAKE = ""

#autoreconf breaks, so we'll skip that. The added advantage is that the patch to ./configure actually has effect
do_configure() {
	oe_runconf COMPILED_BY="${MAINTAINER}"
}

PACKAGES += "${PN}-scenes ${PN}-ini ${PN}-icons ${PN}-scripts ${PN}-includes"

PACKAGE_ARCH_${PN}-doc = "all"

PACKAGE_ARCH_${PN}-scenes = "all"
FILES_${PN}-scenes = "${datadir}/povray-3.6/scenes"

PACKAGE_ARCH_${PN}-ini = "all"
FILES_${PN}-ini = "${datadir}/povray-3.6/ini"

PACKAGE_ARCH_${PN}-icons = "all"
FILES_${PN}-icons = "${datadir}/povray-3.6/icons"

PACKAGE_ARCH_${PN}-scripts = "all"
FILES_${PN}-scripts = "${datadir}/povray-3.6/scripts"

PACKAGE_ARCH_${PN}-includes = "all"
FILES_${PN}-includes = "${datadir}/povray-3.6/include"


SRC_URI[md5sum] = "b5789bb7eeaed0809c5c82d0efda571d"
SRC_URI[sha256sum] = "4e8a7fecd44807343b6867e1f2440aa0e09613d6d69a7385ac48f4e5e7737a73"
