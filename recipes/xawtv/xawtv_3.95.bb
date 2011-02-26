LICENSE = "GPL"
SECTION = "x11/utils"
DESCRIPTION = "XawTV is a simple Xaw-based TV program which uses the bttw \
driver or video4linux.  It also contains various command-line utilities for \
grabbing images and AVI movies, tuning in TV stations, etc."
DEPENDS = "alsa-lib libxaw libxmu libxt libxpm libxext virtual/libx11 ncurses libxft fs jpeg"
PR = "r0"

SRC_URI = "http://dl.bytesex.org/releases/xawtv/xawtv-${PV}.tar.gz \
           file://01_gcc4.patch \
           file://04_man_typo.patch \
           file://05_man_section.patch \
           file://07_page_size.patch \
           file://08_oss_audio.patch \
           file://09_audio_unmute.patch \
           file://10_radio_fixes.patch \
           file://11_plugins_memory_leaks.patch \
           file://12_fbtv_radeonfb.patch \
           file://13_libquicktime_compat.patch \
           file://14_scantv_input_override.patch \
           file://15_xawtv_bin_cutoff.patch \
           file://16_xawtv_v4l2_buffer.patch \
           file://17_scantv_man_typo.patch \
           file://18_glib2.patch \
	   file://make.patch \
           file://sys_siglist.patch \
          "

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
		--disable-zvbi \
		--disable-gl \
		--disable-dv \
		--disable-mmx \
		--enable-xft \
		--x-includes=${STAGING_INCDIR} \
		--x-libraries=${STAGING_LIBDIR}"
EXTRA_OEMAKE += " 'verbose=yes'"

SRC_URI[md5sum] = "ad25e03f7e128b318e392cb09f52207d"
SRC_URI[sha256sum] = "1204212c59d10df4e29a9a0ddce96cab78342859ec44bf6fd1c5f260b5c7216f"
