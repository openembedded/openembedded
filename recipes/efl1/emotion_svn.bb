DESCRIPTION = "The Enlightenment multimedia library"
LICENSE = "MIT BSD"
# we no longer build the libxine backend, since the gstreamer backend seems more promising
DEPENDS = "eet evas ecore edje gstreamer gst-plugins-base"
PV = "0.1.0.042+svnr${SRCREV}"
PR = "r5"

inherit efl

EXTRA_OECONF = "--disable-xine --enable-gstreamer --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

DEBIAN_NOAUTONAME_${PN}-backend-gstreamer = "1"

PACKAGES =+ "emotion-backend-gstreamer"
FILES_emotion-backend-gstreamer = "${libdir}/emotion/*.so"
RRECOMMENDS_${PN} = "emotion-backend-gstreamer"

do_compile_append() {
	sed -i "s/${@"${PKG_CONFIG_SYSROOT_DIR}".replace('/','\/')}\/usr\/local\/lib/\$\{libdir\}/" ${S}/emotion.pc
}
