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

SRC_URI[md5sum] = "86c01dbbcdb41786229f51ec0994ff67"
SRC_URI[sha256sum] = "02b7d27564cb06f56f7fb14cd4a4eb60093c441decfec9b475d892518a5509a1"
