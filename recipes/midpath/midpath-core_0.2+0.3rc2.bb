DESCRIPTION = "MIDPath is a Java library which provides a MIDP2 implementation"

PR = "r6"

SRC_URI = "${SOURCEFORGE_MIRROR}/midpath/midpath-0.3rc2.tar.gz \
	   file://configuration.cfg"

S = "${WORKDIR}/midpath-0.3rc2"

require midpath-common.inc

SRC_URI += "\
  http://jlime.com/downloads/development/patches/sdl-fixes.patch;name=patch \
  file://ui-colors.patch \
  file://fix-openfile.patch \
  file://hci_read_local_name.patch \
  file://midpath-suitemanager \
  file://midpath-launcher-j2se \
  file://midpath-suitemanager.desktop \
  file://midpath.png \
  "

PROVIDES = "java-midp2.0"
DEPENDS += "midpath-cldc midpath-backend-sdl midpath-backend-escher swt3.4-gtk kxml2 bluez-libs"

RDEPENDS_${PN} += "libkxml2-java"

JAR = "midpath.jar"

do_configure() {
  mv ${WORKDIR}/configuration.cfg ${S}/configuration/com/sun/midp/configuration/
}

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
  cp -R configuration ${D}${datadir}/midpath
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

PACKAGES = "${PN}-bluetooth ${PN}-bluetooth-jni ${PN}-bluetooth-jni-dbg ${PN}-mp3 ${PN}-ogg ${PN}"
RDEPENDS_${PN}-bluetooth = "${PN}-bluetooth-jni"

FILES_${PN}-bluetooth = "${datadir}/midpath/avetanabt-cldc.jar"
FILES_${PN}-bluetooth-jni = "${libdir_jni}/lib*.so"
FILES_${PN}-bluetooth-jni-dbg = "${libdir_jni}/.debug/lib*.so"
FILES_${PN}-mp3 = "${datadir}/midpath/jlayerme-cldc.jar"
FILES_${PN}-ogg = "${datadir}/midpath/jorbis-cldc.jar"

FILES_${PN} = "\
  ${datadir}/midpath/*.jar \
  ${datadir}/midpath/configuration \
  ${datadir}/applications \
  ${datadir}/pixmaps \
  ${bindir} \
	"

SRC_URI[md5sum] = "d03cd88f51f82bbcfcfa5b65df0da5b0"
SRC_URI[sha256sum] = "e235ca7470e7cdfb90e3806fbcc1b2c450db286276136a2523c7ae26a804a100"

SRC_URI[patch.md5sum] = "31d8e20f9d89fd77e9c855bfefc58c22"
SRC_URI[patch.sha256sum] = "5fadd05567ed95c4012ba1685344a34ee73c67016cfab43b0db5a1508f4c22da"
