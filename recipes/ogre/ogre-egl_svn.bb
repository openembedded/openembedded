DESCRIPTION = "OGRE (Object-Oriented Graphics Rendering Engine) is a scene-oriented, flexible 3D engine "
LICENSE = "LGPL"
DEPENDS = "gtk+ wgois cppunit zziplib boost freeimage freetype virtual/libx11 virtual/egl"

PR = "r3"

SRCREV = "8310"
PV = "1.6.1+svnr${SRCPV}"

SRC_URI = "svn://ogre.svn.sourceforge.net/svnroot/ogre;module=trunk;proto=https \
           file://ogre-egl-update.diff;patch=1;pnum=0 \
          "

inherit autotools_stage

# This is the EGL version
EXTRA_OECONF = " --with-gui=gtk --disable-freetypetest --enable-ogre-demos --with-allocator=std --enable-threading=no --disable-cg --enable-gles "

S = "${WORKDIR}/trunk"


EXTRA_OEMAKE = " ZZIPLIB_CFLAGS=\"${@base_conditional('SITEINFO_ENDIANESS', 'le', '-DOGRE_CONFIG_LITTLE_ENDIAN', '-DOGRE_CONFIG_BIG_ENDIAN', d)}\" "

do_configure_prepend() {
	sed -i -e /OGRE_DETECT_ENDIAN/d ${S}/configure.in
}

do_install_append() {
	install -d ${D}${datadir}/ogre3d/samples
	mv ${D}${S}/Samples/* ${D}${datadir}/ogre3d/samples/
	cp ${S}/Samples/Common/bin/Release/*cfg ${D}${datadir}/ogre3d/samples/Common/bin

	install -d ${D}${datadir}/ogre3d/Media 
	cp -r ${S}/Samples/Media/* ${D}${datadir}/ogre3d/Media/
	find ${D} -name ".svn" | xargs rm -rf
}

PACKAGES += "${PN}-samples"

FILES_${PN}-samples = "${datadir}/ogre3d/"
FILES_${PN}-dbg += "${libdir}/OGRE/.debug ${datadir}/ogre3d/samples/*/*/.debug"
FILES_${PN}-dev += "${libdir}/OGRE/*.la"
FILES_${PN} += "${libdir}/libOgreMain-*.so ${libdir}/OGRE/*.so"

