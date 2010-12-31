DESCRIPTION = "Digital modem program for Linux"
LICENSE = "GPLv2"

DEPENDS = "libsndfile1 portaudio-v19 hamlib jpeg fltk libsamplerate0 pulseaudio"

inherit gettext autotools

SRC_URI = "http://www.w1hkj.com/downloads/fldigi/fldigi-${PV}.tar.gz"
SRC_URI[md5sum] = "0e8b7707f721eda43a0617ffbe2076cf"
SRC_URI[sha256sum] = "5442f3cd186b3f0c3338be9fd40f26d73bac9e2feee41bb5c7cc3e4ffe7a215d"

EXTRA_OECONF = " --enable-static --without-jpeg"

do_configure_prepend() {
	glib-gettextize --force --copy || true
	cp ${STAGING_DATADIR}/glib-2.0/gettext/mk* ${S}
}

