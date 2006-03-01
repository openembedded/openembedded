LICENSE = "GPL"
SECTION = "x11/utils"
DESCRIPTION = "XawTV is a simple Xaw-based TV program which uses the bttw \
driver or video4linux.  It also contains various command-line utilities for \
grabbing images and AVI movies, tuning in TV stations, etc."
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
DEPENDS = "libxaw libxmu libxt libxpm libxext libx11 ncurses libxft fs jpeg"

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
