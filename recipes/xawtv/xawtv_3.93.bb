LICENSE = "GPL"
SECTION = "x11/utils"
DESCRIPTION = "XawTV is a simple Xaw-based TV program which uses the bttw \
driver or video4linux.  It also contains various command-line utilities for \
grabbing images and AVI movies, tuning in TV stations, etc."
DEPENDS = "libxaw libxmu libxt libxpm libxext virtual/libx11 ncurses libxft fs jpeg"

SRC_URI = "http://dl.bytesex.org/releases/xawtv/xawtv-${PV}.tar.gz \
	   file://make.patch;patch=1"
S = "${WORKDIR}/xawtv-${PV}"

inherit autotools

# FIXME: libXaw needs a full x11, not diet
BROKEN = "1"

EXTRA_OECONF = "--disable-xfree-ext \
		--disable-xvideo \
		--disable-lirc \
		--disable-quicktime \
		--disable-motif \
		--disable-aa \
		--disable-alsa \
		--disable-zvbi \
		--disable-gl \
		--disable-dv \
		--disable-mmx \
		--enable-xft \
		--x-includes=${STAGING_INCDIR} \
		--x-libraries=${STAGING_LIBDIR}"
EXTRA_OEMAKE += " 'verbose=yes'"

SRC_URI[md5sum] = "8d2731e6e95f173f41a0ddc875d55804"
SRC_URI[sha256sum] = "d5e333bc74c0a534bf96f40ea89b7e700f137d46f1fdbaea13fa552ad6227af8"
