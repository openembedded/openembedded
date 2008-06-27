require midpath-common.inc

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/midpath/midpath-0.3rc1.tar.gz"

S = "${WORKDIR}/midpath-0.3rc1"

DEPENDS = "midpath-core midpath-location midpath-messaging midpath-svg midpath-opengles midpath-m3g"
RDEPENDS = "midpath midpath-location midpath-messaging midpath-svg-midp midpath-opengles midpath-m3g"

DESCRIPTION = "Demonstration programs of the MIDPath library"

JAR = "midpath-demos.jar"

do_compile() {
  # Only Demos enabled.
  midpath_build \
    --disable-midpath \
    --disable-cldc \
    --disable-sdljava-cldc \
    --disable-escher-cldc \
    --disable-jlayerme-cldc \
    --disable-jorbis-cldc \
    --disable-avetanabt-cldc \
    --disable-jgl-cldc \
    --disable-web_services-api \
    --disable-messaging-api \
    --disable-svg-api \
    --disable-opengl-api \
    --disable-m3g-api \
    --with-location-jar=${STAGING_DATADIR}/midpath/jsr179-location.jar \
    --with-messaging-jar=${STAGING_DATADIR}/midpath/jsr205-messaging.jar \
    --with-svg-core-jar=${STAGING_DATADIR}/midpath/jsr226-svg-core.jar \
    --with-opengles-core-jar=${STAGING_DATADIR}/midpath/jsr239-opengles-core.jar \
    --with-opengles-nio-jar=${STAGING_DATADIR}/midpath/jsr239-opengles-nio.jar \
    --with-m3g-jar=${STAGING_DATADIR}/midpath/jsr184-m3g.jar \
    --with-avetanabt-cldc-jar=${STAGING_DATADIR}/midpath/avetanabt-cldc.jar
}

do_install() {
	install -d ${D}${datadir}/midpath/repository
	install -m 0644 dist/${JAR} ${D}${datadir}/midpath/repository
}

do_stage() {
	install -d ${STAGING_DATADIR}/midpath/repository
	install -m 0644 dist/${JAR} ${STAGING_DATADIR}/midpath/repository
}
	
PACKAGES = "${PN}"

FILES_${PN} = "${datadir}/midpath/repository/${JAR}"
