DESCRIPTION = "The Persistence of Vision Raytracer is a high-quality, totally free tool for creating stunning three-dimensional graphics. "
HOMEPAGE = "http://www.povray.org"
SECTION = "console/graphics"
LICENSE = "povray"
DEPENDS = "virtual/libx11 boost zlib jpeg libpng tiff"

PR = "r2"

#We apply a patch that subverts the checks for jpeg, zlib, png and tiff because we know OE has the required versions, but it is still a hack.
SRC_URI = "http://www.povray.org/redirect/www.povray.org/beta/source/povray-src-3.7.0.beta.25b.tar.bz2 \
           file://configure-cross-hack.patch;patch=1 \
	   file://gcc43.diff;patch=1 \
           file://boost.patch;patch=1 \
	   "

S = "${WORKDIR}/povray-3.7.0.beta.25b"

inherit autotools pkgconfig

EXTRA_OECONF = " --with-boost-thread=boost_thread-mt \
                 --x-includes=${STAGING_INCDIR} \
                 --disable-vsnprintf-check \
                 COMPILED_BY=${MAINTAINER} "

FULL_OPTIMIZATION_armv7a = "-fexpensive-optimizations -frename-registers -fomit-frame-pointer -O3 -ftree-vectorize  -ffast-math -fno-math-errno "

PACKAGES += "${PN}-scenes ${PN}-ini ${PN}-icons ${PN}-scripts ${PN}-includes"

PACKAGE_ARCH_${PN}-doc = "all"

PACKAGE_ARCH_${PN}-scenes = "all"
FILES_${PN}-scenes = "${datadir}/povray-3.7/scenes"

PACKAGE_ARCH_${PN}-ini = "all"
FILES_${PN}-ini = "${datadir}/povray-3.7/ini"

PACKAGE_ARCH_${PN}-icons = "all"
FILES_${PN}-icons = "${datadir}/povray-3.7/icons"

PACKAGE_ARCH_${PN}-scripts = "all"
FILES_${PN}-scripts = "${datadir}/povray-3.7/scripts"

PACKAGE_ARCH_${PN}-includes = "all"
FILES_${PN}-includes = "${datadir}/povray-3.7/include"

