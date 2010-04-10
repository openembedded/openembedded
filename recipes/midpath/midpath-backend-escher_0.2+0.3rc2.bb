require midpath-common.inc

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/midpath/midpath-0.3rc2.tar.gz"

S = "${WORKDIR}/midpath-0.3rc2"

DEPENDS += "midpath-cldc"

do_compile() {
  # Only escher-cldc is enabled
  midpath_build \
    --disable-cldc \
    --disable-midpath \
    --disable-sdljava-cldc \
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
}

do_install() {
	install -d ${D}${datadir}/midpath
	install -m 0644 dist/escher-cldc.jar ${D}${datadir}/midpath
}

do_stage() {
	install -d ${STAGING_DATADIR}/midpath
	install -m 0644 dist/escher-cldc.jar ${STAGING_DATADIR}/midpath
}
	
PACKAGES = "${PN}"

FILES_${PN}  = "${datadir}/midpath/escher-cldc.jar"

SRC_URI[md5sum] = "d03cd88f51f82bbcfcfa5b65df0da5b0"
SRC_URI[sha256sum] = "e235ca7470e7cdfb90e3806fbcc1b2c450db286276136a2523c7ae26a804a100"
