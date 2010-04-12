DESCRIPTION = "Xqt2 is an X-Server than runs within the Opie environment"
HOMEPAGE = "http://xqt.sourceforge.jp"
DEPENDS = "freetype libxi xmu flex-native virtual/libqte2 libqpe-opie"
LICENSE = "GPL"
SECTION = "opie/applications"
APPTYPE = "binary"
APPNAME = "Xqt"
PR = "r4"

inherit palmtop

SRC_URI = "cvs://anonymous@cvs.sourceforge.jp/cvsroot/xqt;module=xqt2;method=pserver;date=${PV} \
        ftp://ftp.xfree86.org/pub/XFree86/4.3.0/source/X430src-1.tgz;name=archive1 \
        ftp://ftp.xfree86.org/pub/XFree86/4.3.0/source/X430src-2.tgz;name=archive2 \
        ftp://ftp.xfree86.org/pub/XFree86/4.3.0/source/X430src-3.tgz;name=archive3 \
        ftp://ftp.xfree86.org/pub/XFree86/4.3.0/source/X430src-4.tgz;name=archive4 \
        ftp://ftp.xfree86.org/pub/XFree86/4.3.0/source/X430src-5.tgz;name=archive5 \
        file://KeyMap.patch;patch=1 \
        file://moc_call.patch;patch=1 \
        file://imake-staging.patch;patch=1 \
        file://cross.patch;patch=1 \
        file://fephack.patch;patch=1 \
        file://xchar2b.patch;patch=1 \
        file://xqt-make.patch;patch=1 \ 
        file://fix_qtscreen_HACK.patch;patch=1 \
	file://fix_seqfault_qtscreen.patch;patch=1 "
S = "${WORKDIR}/xc"

QT_LIBRARY = '${@base_conditional("PALMTOP_USE_MULTITHREADED_QT", "yes", "qte-mt", "qte",d)}'
QT_LIBRARY_append_c7x0 = " -laticore"

do_configure() {
	#general config
	echo "#define BuildServersOnly YES" > config/cf/host.def
	echo "#define ProjectRoot /usr" >> config/cf/host.def

	# do not build these XServers
	echo "#define XnestServer NO"  >> config/cf/host.def
	echo "#define XdmxServer NO"  >> config/cf/host.def

	# build commands
	echo "#define CcCmd ${CC}" >> config/cf/host.def
	echo "#define CplusplusCmd ${CXX}" >> config/cf/host.def
	echo "#define LdCmd ${LD}" >> config/cf/host.def

	# Qt defines
	echo "#define QtCmnDefs -fno-exceptions -fno-rtti" >> config/cf/host.def
	echo "#define QtDir ${QTDIR}" >> config/cf/host.def
	echo "#define QtLibs -lqpe -l${QT_LIBRARY} -lm -lpng -ljpeg -lts -lsupc++" >> config/cf/host.def
	echo "#define MocBin ${STAGING_BINDIR_NATIVE}/moc" >> config/cf/host.def
	echo "#define QtDefs -DQWS -DOPIE_NEW_MALLOC -DOPIE_NO_ERASE_RECT_HACKFIX  QtCmnDefs" >> config/cf/host.def

	# Build these XServers
	echo "#define XqtXServer  YES" >> config/cf/host.def
	echo "#define XF86Server  NO"  >> config/cf/host.def
	echo "#define TinyXServer YES" >> config/cf/host.def
	echo "#define KDriveXServer YES" >> config/cf/host.def
	echo "#define KdriveServerExtraDefines -DDDXOSFATALERROR -DDDXOSVERRORF" >> config/cf/host.def

	# General Config
	echo "#define SystemUsrIncDir ${STAGING_INCDIR}" >> config/cf/host.def
	echo "#define IncRoot ${STAGING_INCDIR}" >> config/cf/host.def
	echo "#define LdPostLib -L${STAGING_LIBDIR}" >> config/cf/host.def

	echo "#undef BuildRandR " >> config/cf/host.def
	echo "#define BuildRandR YES" >> config/cf/host.def
	echo "#define BuildLBX YES" >> config/cf/host.def

	# change standard defines
	if [ ${TARGET_ARCH} == "arm" ]; then
		echo "#define StandardDefines -Dlinux -D__arm__ -D_POSIX_SOURCE -D_BSD_SOURCE -D_GNU_SOURCE" >> config/cf/host.def
		echo "#define Arm32Architecture" >> config/cf/host.def
	fi
	echo "" > config/cf/date.def
}

do_compile() {
    export TOPDIR=${TOPDIR}
    mkdir -p programs/Xserver/hw/xqt
    #cp -R ../xqt-driver/* programs/Xserver/hw/xqt
    (cd programs/Xserver/hw/xqt && ln -s ../../../../../xqt2/xfree86/xqt-driver/* .)
	unset CC
	make -C config/imake -f Makefile.ini CC="${BUILD_CC}" BOOTSTRAPCFLAGS="${BUILD_CFLAGS}" clean imake
	make CC="${BUILD_CC}" xmakefile
	make Makefiles
	make clean
	#make depend
	make includes CC="${BUILD_CC}"
	make -C config/util CC="${BUILD_CC}"
	for l in font xtrans Xdmcp Xau lbxutil; do make -C lib/$l CC="${CC}" LD="${LD}" CC_STAGING="-I${STAGING_INCDIR}" LD_STAGING="-L${STAGING_LIBDIR}"; done
	make -C programs/Xserver CC="${CC}" LD="${LD}" CC_STAGING="-I${STAGING_INCDIR}" LD_STAGING="-L${STAGING_LIBDIR}" INSTALLED_LIBS=""
}

do_stage() {
	install -d ${STAGING_INCDIR}/xserver-xqt
	install -m 0644 programs/Xserver/hw/xfree86/common/fourcc.h ${STAGING_INCDIR}/xserver-xqt
}

do_install() {
	oe_runmake -C programs/Xserver DESTDIR="${D}" CC="${CC}" LD="${LD}" \
                   CC_STAGING="-I${STAGING_INCDIR}" LD_STAGING="-L${STAGING_LIBDIR}" INSTALLED_LIBS="" install
	oe_runmake -C lib/font DESTDIR="${D}" CC="${CC}" LD="${LD}" \
                   CC_STAGING="-I${STAGING_INCDIR}" LD_STAGING="-L${STAGING_LIBDIR}" INSTALLED_LIBS="" install

	install -d ${D}${palmtopdir}/apps/Applications/
	install -m 0644 ${WORKDIR}/xqt2/xfree86/files/Xqt.desktop ${D}${palmtopdir}/apps/Applications
	install -d ${D}${palmtopdir}/pics
	install -m 0644 programs/Xserver/hw/xqt/Xqt.png ${D}${palmtopdir}/pics
}

PACKAGE_ARCH_c7x0 = "${MACHINE_ARCH}"

SRC_URI[archive1.md5sum] = "4f241a4f867363f40efa2b00dca292af"
SRC_URI[archive1.sha256sum] = "5276b045e154948fce7abba7d686406c65862d90b43b50f2546b33e38378f0d7"
SRC_URI[archive2.md5sum] = "844c2ee908d21dbf8911fd13115bf8b4"
SRC_URI[archive2.sha256sum] = "0afbf41d0f4bcaceb1381fc1882b80f62548845b85c83c3eb0f3a9ac7f7f96ef"
SRC_URI[archive3.md5sum] = "b82a0443e1b7bf860e4343e6b6766cb6"
SRC_URI[archive3.sha256sum] = "19a830e3657851ad575ca895eb59932f1d90cd03735dec68f900dbc1bb6c3b7f"
SRC_URI[archive4.md5sum] = "567903747018f2534965ab6cb3976b38"
SRC_URI[archive4.sha256sum] = "f62081c6f8a70a35fb0b5b210329f6bba7f5e506e9b809e23ceba21a2c35278e"
SRC_URI[archive5.md5sum] = "4dbdbe9a85c8f7f98dd0ee015a3c7b4f"
SRC_URI[archive5.sha256sum] = "3b732ed179dd34c17d1ba17867b60a36f20d82a3f0eca7b084fcb5396aa2b30c"
