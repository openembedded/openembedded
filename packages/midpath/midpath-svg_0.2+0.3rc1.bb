require midpath-common.inc

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/midpath/midpath-0.3rc1.tar.gz"

S = "${WORKDIR}/midpath-0.3rc1"

DEPENDS += "midpath-core midpath-webservices"
RDEPENDS_${PN}-midp = "${PN}"
RDEPENDS_${PN}-awt = "${PN}"

DESCRIPTION = "Implementation of the JSR226 SVG API for use in the MIDPath library"

JAR = "jsr226-svg-core.jar"
JAR2 = "jsr226-svg-midp2.jar"
JAR3 = "jsr226-svg-core.jar"

do_compile() {
  # Only SVG API is enabled.
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
    --disable-location-api \
    --disable-messaging-api \
    --disable-opengl-api \
    --disable-m3g-api \
    --disable-demos \
    --enable-svg-api-awt \
    --with-jaxp-jar=${STAGING_DATADIR}/midpath/jsr172-jaxp.jar
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
	
PACKAGES = "${PN} ${PN}-midp ${PN}-awt"

FILES_${PN}  = "${datadir}/midpath/${JAR}"

FILES_${PN}-midp  = "${datadir}/midpath/${JAR2}"

FILES_${PN}-awt  = "${datadir}/midpath/${JAR3}"
