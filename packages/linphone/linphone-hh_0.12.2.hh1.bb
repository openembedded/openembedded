LICENSE = GPL
SECTION = "x11/utils"
PR = "r4"

DESCRIPTION = "SIP-based IP phone (GPE edition)"
DEPENDS = "libosip gtk+ libogg alsa-lib"
SRC_URI = "http://handhelds.org/pub/linux/packages/linphone/linphone-${PV}.tar.gz \
	file://osipua-ipv6-lossage.patch;patch=1 \
	file://gpe-cross-lossage.patch;patch=1 \
	file://disable-gtk-doc.patch;patch=1 \
	file://dotdesktop.patch;patch=1 \
	file://segfault.patch;patch=1"

S = "${WORKDIR}/linphone-${PV}"

FILES_${PN} += "${datadir}/linphonec"

inherit autotools

EXTRA_OECONF = "--disable-gnome_ui --disable-gtk-doc"

do_configure() {
	# ffmpeg is in AC_SUBDIRS, but doesn't actually use autoconf.
	# Autoreconf will try to recurse into there and blow up.
	for dir in . speex oRTP osipua; do
		( cd $dir; libtoolize --force; aclocal; automake; autoconf )
	done

	oe_runconf
}

do_install_append() {
	mv ${D}${datadir}/gnome/apps/Internet ${D}${datadir}/applications
	rm -f ${D}${datadir}/sounds/linphone/hello*.wav
	rm -f ${D}${datadir}/sounds/linphone/rings/oldphone.wav
}
