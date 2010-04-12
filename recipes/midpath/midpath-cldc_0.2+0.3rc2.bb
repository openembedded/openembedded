require midpath-common.inc

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/midpath/midpath-0.3rc2.tar.gz"

S = "${WORKDIR}/midpath-0.3rc2"

DESCRIPTION = "Implementation of the CLDC profile for use in the MIDPath library"
RPROVIDES  = "midpath-cldc java-cldc1.1"

JAR = "midpath-cldc1.1.jar"

do_compile() {
  midpath_build \
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
    --with-cldc-jar=dist/${JAR}
}

do_install() {
	install -d ${D}${datadir}/midpath-cldc
	install -m 0644 dist/${JAR} ${D}${datadir}/midpath-cldc
}

do_stage() {
	install -d ${STAGING_DATADIR}/midpath-cldc
	install -m 0644 dist/${JAR} ${STAGING_DATADIR}/midpath-cldc
}
	
PACKAGES = "${PN}"

FILES_${PN}  = "${datadir}/midpath-cldc/${JAR}"

SRC_URI[md5sum] = "d03cd88f51f82bbcfcfa5b65df0da5b0"
SRC_URI[sha256sum] = "e235ca7470e7cdfb90e3806fbcc1b2c450db286276136a2523c7ae26a804a100"
