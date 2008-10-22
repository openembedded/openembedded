LICENSE = "GPL"
SECTION = "x11/utils"
PR = "r2"

DESCRIPTION = "SIP-based IP phone (GPE edition)"
DEPENDS = "libosip gtk+ libogg libgnomeui"
SRC_URI = "http://simon.morlat.free.fr/download/0.12.2/source/linphone-${PV}.tar.gz \
	file://osip-lossage.patch;patch=1 \
	file://disable-gtk-doc.patch;patch=1"

FILES_${PN} += "${datadir}/linphonec"

EXTRA_OECONF = "--disable-gtk-doc"

inherit autotools

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
