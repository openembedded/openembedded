require midpath-common.inc

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/midpath/midpath-0.3rc1.tar.gz"

S = "${WORKDIR}/midpath-0.3rc1"

DEPENDS = "classpath linux-libc-headers"

do_compile() {
  # Only ALSA backend library is enabled
  midpath_build \
    --disable-cldc \
    --disable-midpath \
    --disable-sdljava-cldc \
    --disable-escher-cldc \
    --disable-jlayerme-cldc \
    --disable-jorbis-cldc \
    --disable-avetanabt-cldc \
    --disable-jgl-cldc \
    --disable-web_services-api \
    --disable-location-api \
    --disable-messaging-api \
    --disable-svg-api \
    --disable-opengl-api \
    --disable-m3g-api \
    --disable-demos \
    --alsa
}

do_install() {
	oe_libinstall -C dist -so libmidpathalsa ${D}${libdir_jni}
}

do_stage() {
  :
}
	
PACKAGES = "${PN} ${PN}-dbg"

FILES_${PN} = "${libdir_jni}/lib*.so"
FILES_${PN}-dbg  = "${libdir_jni}/.debug/lib*.so"
