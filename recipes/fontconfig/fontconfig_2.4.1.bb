require fontconfig.inc

PR = "r4"

SRC_URI += "https://stage.maemo.org/svn/maemo/projects/haf/trunk/fontconfig/device_symbols.h;name=deviceSymbols \
	    file://configure_fix.patch;patch=1 "

EXTRA_OECONF += " --with-arch=${HOST_ARCH}"

do_stage () {
	cp ${WORKDIR}/device_symbols.h ${S}/fontconfig/
	oe_libinstall -so -a -C src libfontconfig ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/fontconfig
	for i in ${S}/fontconfig/*.h; do install -m 0644 $i ${STAGING_INCDIR}/fontconfig/; done
        ln -sf ${STAGING_INCDIR}/fontconfig/device_symbols.h ${STAGING_INCDIR}
}

BUILD_CFLAGS += " -I${STAGING_INCDIR_NATIVE}/freetype2"

do_configure_append () {
	sed -i 's|LDFLAGS =.*|LDFLAGS =|' fc-case/Makefile
	sed -i 's|LDFLAGS =.*|LDFLAGS =|' fc-glyphname/Makefile
	sed -i 's|LDFLAGS =.*|LDFLAGS =|' fc-lang/Makefile
	sed -i 's|LDFLAGS =.*|LDFLAGS =|' fc-arch/Makefile

	sed -i 's|CFLAGS =.*|CFLAGS =${BUILD_CFLAGS}|' fc-case/Makefile
	sed -i 's|CFLAGS =.*|CFLAGS =${BUILD_CFLAGS}|' fc-glyphname/Makefile
	sed -i 's|CFLAGS =.*|CFLAGS =${BUILD_CFLAGS}|' fc-lang/Makefile
	sed -i 's|CFLAGS =.*|CFLAGS =${BUILD_CFLAGS}|' fc-arch/Makefile

	sed -i 's|CPPFLAGS =.*|CPPFLAGS =${BUILD_CPPFLAGS}|' fc-case/Makefile
	sed -i 's|CPPFLAGS =.*|CPPFLAGS =${BUILD_CPPFLAGS}|' fc-glyphname/Makefile
	sed -i 's|CPPFLAGS =.*|CPPFLAGS =${BUILD_CPPFLAGS}|' fc-lang/Makefile
	sed -i 's|CPPFLAGS =.*|CPPFLAGS =${BUILD_CPPFLAGS}|' fc-arch/Makefile

	sed -i 's|CXXFLAGS =.*|CFLAGS =${BUILD_CXXFLAGS}|' fc-case/Makefile
	sed -i 's|CXXFLAGS =.*|CFLAGS =${BUILD_CXXFLAGS}|' fc-glyphname/Makefile
	sed -i 's|CXXFLAGS =.*|CFLAGS =${BUILD_CXXFLAGS}|' fc-lang/Makefile
	sed -i 's|CXXFLAGS =.*|CFLAGS =${BUILD_CXXFLAGS}|' fc-arch/Makefile

}

do_install () {
	autotools_do_install
}


SRC_URI[md5sum] = "108f9a03fa9ed9dd779cc7ca236da557"
SRC_URI[sha256sum] = "13f59a7cd5190983412689495c399444cf73c1ced0813149e4480c8848bb9f17"
SRC_URI[deviceSymbols.md5sum] = "c0124afc760d4fe8c24ffcf15ba7f391"
SRC_URI[deviceSymbols.sha256sum] = "4e0c1726f9c565deec6d6af9eebda47ca6dea473f3280cc89beb321ae33ff962"
