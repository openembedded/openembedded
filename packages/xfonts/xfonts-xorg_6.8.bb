SECTION = "x11/base"
PR = "r0"
LICENSE = "XFree86"

SRC_URI = "cvs://anoncvs@cvs.freedesktop.org/cvs/xorg;module=xc;tag=XORG-6_8_0;method=pserver \
        file://imake-staging.patch;patch=1"

inherit native

PACKAGES = "${PN}-75dpi ${PN}-100dpi ${PN}-type1 ${PN}-cyrillic ${PN}-ttf ${PN}"
FILES_${PN}-75dpi = "${libdir}/X11/fonts/75dpi"
FILES_${PN}-100dpi = "${libdir}/X11/fonts/100dpi"
FILES_${PN}-type1 = "${libdir}/X11/fonts/Type1"
FILES_${PN}-ttf = "${libdir}/X11/fonts/TTF"
FILES_${PN}-cyrillic = "${libdir}/X11/fonts/cyrillic"
FILES_${PN} = "${libdir}/X11/fonts"

PACKAGE_ARCH = "all"

S = "${WORKDIR}/xc"

do_configure() {
	echo "#define ProjectRoot /usr" >> config/cf/host.def
	echo "#define XnestServer NO"  >> config/cf/host.def
	echo "#define XdmxServer NO"  >> config/cf/host.def
	echo "#define CcCmd ${CC}" >> config/cf/host.def
	echo "#define LdCmd ${LD}" >> config/cf/host.def
	echo "" > config/cf/date.def
}

do_compile() {
	make -C config/imake -f Makefile.ini CC="${BUILD_CC}" BOOTSTRAPCFLAGS="${BUILD_CFLAGS}" clean imake
	make CC="${BUILD_CC}" xmakefile
	make Makefiles
	make clean
	#make depend
	make includes
	make -C config/util
	make -C lib/font
	make -C lib/fontenc
	make -C lib/fontconfig
	make -C programs/mkfontscale
	make -C programs/bdftopcf
	make -C programs/fc-cache
	make -C fonts
}

do_install() {
	make -C fonts DESTDIR="${D}" install
}

do_stage() {
	:
}
