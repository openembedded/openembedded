require midpath-common.inc

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/midpath/midpath-0.3rc2.tar.gz"

S = "${WORKDIR}/midpath-0.3rc2"

DEPENDS += "midpath-core midpath-jgl"
RDEPENDS_${PN} = "midpath-core midpath-jgl ${PN}-core ${PN}-nio"

DESCRIPTION = "Implementation of the JSR239 OpenGL ES API for use in the MIDPath library"

JAR = "jsr239-opengles-jgl.jar"
JAR2 = "jsr239-opengles-core.jar"
JAR3 = "jsr239-opengles-nio.jar"

do_compile() {
  # Only OpenGL ES API is enabled.
  midpath_build \
    --disable-midpath \
    --disable-cldc \
    --disable-sdljava-cldc \
    --disable-escher-cldc \
    --disable-jlayerme-cldc \
    --disable-jorbis-cldc \
    --disable-jgl-cldc \
    --disable-avetanabt-cldc \
    --disable-web_services-api \
    --disable-location-api \
    --disable-messaging-api \
    --disable-svg-api \
    --disable-m3g-api \
    --disable-demos \
    --with-jgl-cldc-jar=${STAGING_DATADIR}/midpath/jgl-cldc.jar
}

do_install() {
	install -d ${D}${datadir}/midpath
	install -m 0644 dist/${JAR} ${D}${datadir}/midpath
	install -m 0644 dist/${JAR2} ${D}${datadir}/midpath
	install -m 0644 dist/${JAR3} ${D}${datadir}/midpath
}

do_stage() {
	install -d ${STAGING_DATADIR}/midpath
	install -m 0644 dist/${JAR} ${STAGING_DATADIR}/midpath
	install -m 0644 dist/${JAR2} ${STAGING_DATADIR}/midpath
	install -m 0644 dist/${JAR3} ${STAGING_DATADIR}/midpath
}
	
PACKAGES = "${PN} ${PN}-core ${PN}-nio"

FILES_${PN} = "${datadir}/midpath/${JAR}"
FILES_${PN}-core = "${datadir}/midpath/${JAR2}"
FILES_${PN}-nio = "${datadir}/midpath/${JAR3}"

SRC_URI[md5sum] = "d03cd88f51f82bbcfcfa5b65df0da5b0"
SRC_URI[sha256sum] = "e235ca7470e7cdfb90e3806fbcc1b2c450db286276136a2523c7ae26a804a100"
