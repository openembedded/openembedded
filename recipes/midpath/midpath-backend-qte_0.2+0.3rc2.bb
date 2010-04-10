require midpath-common.inc

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/midpath/midpath-0.3rc2.tar.gz"

S = "${WORKDIR}/midpath-0.3rc2"

DEPENDS = "classpath qte-mt"
RCONFLICTS = "midpath-backend-qt3"

inherit qt3e

do_compile() {
  # Only native qt3 backend library is enabled
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
    --qte
}

do_install() {
	oe_libinstall -C dist -so libmidpathqt ${D}${libdir_jni}
}

do_stage() {
  :
}
	
PACKAGES = "${PN} ${PN}-dbg"

FILES_${PN} = "${libdir_jni}/lib*.so"
FILES_${PN}-dbg  = "${libdir_jni}/.debug/lib*.so"


SRC_URI[md5sum] = "d03cd88f51f82bbcfcfa5b65df0da5b0"
SRC_URI[sha256sum] = "e235ca7470e7cdfb90e3806fbcc1b2c450db286276136a2523c7ae26a804a100"
