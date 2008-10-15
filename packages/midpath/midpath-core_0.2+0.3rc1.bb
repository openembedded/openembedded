DESCRIPTION = "MIDPath is a Java library which provides a MIDP2 implementation"

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/midpath/midpath-0.3rc1.tar.gz"

S = "${WORKDIR}/midpath-0.3rc1"

require midpath-common.inc

SRC_URI += "\
  file://midpath-suitemanager \
  file://midpath-launcher-j2se \
  file://midpath-suitemanager.desktop \
  file://midpath.png \
  "

PROVIDES = "java-midp2.0"
DEPENDS += "midpath-cldc midpath-backend-sdl midpath-backend-escher swt3.4-gtk kxml2 bluez-libs"

RDEPENDS += "libkxml2-java"

JAR = "midpath.jar"

do_compile() {
  midpath_build \
    --disable-cldc \
    --disable-sdljava-cldc \
    --disable-escher-cldc \
    --disable-jgl-cldc \
    --disable-web_services-api \
    --disable-location-api \
    --disable-messaging-api \
    --disable-svg-api \
    --disable-opengl-api \
    --disable-m3g-api \
    --disable-demos \
    --with-sdljava-cldc=${STAGING_DATADIR}/midpath/sdljava-cldc.jar \
    --with-escher-cldc=${STAGING_DATADIR}/midpath/escher-cldc.jar \
    --with-swt-jar=${STAGING_DATADIR_JAVA}/swt.jar \
    --with-midpath-jar=${S}/dist/midpath.jar \
    --bt
}

do_install() {
  oe_libinstall -C dist -so libavetanabtcldc ${D}${libdir_jni}

	install -d ${D}${datadir}/midpath
	install -m 0644 dist/${JAR} ${D}${datadir}/midpath
	install -m 0644 dist/microbackend.jar ${D}${datadir}/midpath
	install -m 0644 dist/avetanabt-cldc.jar ${D}${datadir}/midpath
	install -m 0644 dist/jorbis-cldc.jar ${D}${datadir}/midpath
	install -m 0644 dist/jlayerme-cldc.jar ${D}${datadir}/midpath

  install -d ${D}${bindir}
  install -m 0755 ${WORKDIR}/midpath-launcher-j2se ${D}${bindir}
  install -m 0755 ${WORKDIR}/midpath-suitemanager ${D}${bindir}

  install -d ${D}${datadir}/applications
  install -m 0644 ${WORKDIR}/midpath-suitemanager.desktop ${D}${datadir}/applications

  install -d ${D}${datadir}/pixmaps
  install -m 0644 ${WORKDIR}/midpath.png ${D}${datadir}/pixmaps
}

do_stage() {
	install -d ${STAGING_DATADIR}/midpath
	install -m 0644 dist/${JAR} ${STAGING_DATADIR}/midpath
	install -m 0644 dist/microbackend.jar ${STAGING_DATADIR}/midpath
	install -m 0644 dist/avetanabt-cldc.jar ${STAGING_DATADIR}/midpath
	install -m 0644 dist/jorbis-cldc.jar ${STAGING_DATADIR}/midpath
	install -m 0644 dist/jlayerme-cldc.jar ${STAGING_DATADIR}/midpath
}

PACKAGES = "${PN}-bluetooth ${PN}-bluetooth-jni ${PN}-bluetooth-jni-dbg ${PN}-mp3 ${PN}-ogg ${PN}"
RDEPENDS_${PN}-bluetooth = "${PN}-bluetooth-jni"

FILES_${PN}-bluetooth = "${datadir}/midpath/avetanabt-cldc.jar"
FILES_${PN}-bluetooth-jni = "${libdir_jni}/lib*.so"
FILES_${PN}-bluetooth-jni-dbg = "${libdir_jni}/.debug/lib*.so"
FILES_${PN}-mp3 = "${datadir}/midpath/jlayerme-cldc.jar"
FILES_${PN}-ogg = "${datadir}/midpath/jorbis-cldc.jar"

FILES_${PN} = "\
  ${datadir}/midpath/*.jar \
  ${datadir}/applications \
  ${datadir}/pixmaps \
  ${bindir} \
	"

