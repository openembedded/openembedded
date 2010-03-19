require fontconfig.inc

PR = "r4"

SRC_URI += "https://stage.maemo.org/svn/maemo/projects/haf/trunk/fontconfig/device_symbols.h \
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

