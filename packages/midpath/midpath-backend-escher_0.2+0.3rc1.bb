require midpath-common.inc

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/midpath/midpath-0.3rc1.tar.gz"

S = "${WORKDIR}/midpath-0.3rc1"

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
