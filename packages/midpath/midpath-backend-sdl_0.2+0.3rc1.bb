require midpath-common.inc

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/midpath/midpath-0.3rc1.tar.gz"

S = "${WORKDIR}/midpath-0.3rc1"

DEPENDS += "midpath-cldc virtual/libsdl libsdl-mixer libsdl-ttf libsdl-image libsdl-gfx"

RDEPENDS_${PN} = "${PN}-jni"

do_compile() {
  # Only sdljava-cldc and native SDL backend library is enabled
  midpath_build \
    --disable-cldc \
    --disable-midpath \
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
    --sdl \
    --with-sdl-include="`sdl-config --cflags`"
}

do_install() {
	install -d ${D}${datadir}/midpath
	install -m 0644 dist/sdljava-cldc.jar ${D}${datadir}/midpath

	install -d ${D}${libdir_jni}
	oe_libinstall -C dist -so libsdljava ${D}${libdir_jni}
	oe_libinstall -C dist -so libsdljava_mixer ${D}${libdir_jni}
	oe_libinstall -C dist -so libsdljava_ttf ${D}${libdir_jni}
	oe_libinstall -C dist -so libsdljava_image ${D}${libdir_jni}
	oe_libinstall -C dist -so libsdljava_gfx ${D}${libdir_jni}
}

do_stage() {
	install -d ${STAGING_DATADIR}/midpath
	install -m 0644 dist/sdljava-cldc.jar ${STAGING_DATADIR}/midpath
}
	
PACKAGES = "${PN} ${PN}-jni ${PN}-jni-dbg"

FILES_${PN}  = "\
		${datadir}/midpath/sdljava-cldc.jar \
		"

FILES_${PN}-jni  = "${libdir_jni}/lib*.so"
FILES_${PN}-jni-dbg  = "${libdir_jni}/.debug/lib*.so"

