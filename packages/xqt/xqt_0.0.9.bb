HOMEPAGE = "http://xqt.sourceforge.jp"
LICENSE = "GPL"
SECTION = "x11/base"


CVSDATE = "20041111"
DEPENDS = "freetype libxi xmu flex-2.5.4-native virtual/libqte2 libqpe-opie"

SRC_URI = "cvs://anonymous@cvs.sourceforge.jp/cvsroot/xqt;module=xc;method=pserver \
	   file://imake-staging.patch;patch=1 \
	   file://moc_call.patch;patch=1 "


S = "${WORKDIR}/xc"

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
	echo "#define QtLibs -lqpe -lqte -lm -lpng -ljpeg -lts -lsupc++" >> config/cf/host.def
	echo "#define MocBin ${STAGING_BINDIR}/moc" >> config/cf/host.def
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

do_install() {
	make -C programs/Xserver DESTDIR="${D}" CC="${CC}" LD="${LD}" CC_STAGING="-I${STAGING_INCDIR}" LD_STAGING="-L${STAGING_LIBDIR}" INSTALLED_LIBS="" install
	make -C lib/font DESTDIR="${D}" CC="${CC}" LD="${LD}" CC_STAGING="-I${STAGING_INCDIR}" LD_STAGING="-L${STAGING_LIBDIR}" INSTALLED_LIBS="" install
	
	install -d ${D}${palmtopdir}/apps/Applications
	install -d ${D}${palmtopdir}/pics/Xqt
	
	install -m 0644 programs/Xserver/hw/xqt/Xqt.png ${D}${palmtopdir}/pics/Xqt
	install -m 0644 IPKG/Xqt.desktop ${D}${palmtopdir}/apps/Applications		
}

do_stage() {
	install -d ${STAGING_INCDIR}/xserver-xqt
	install -m 0644 programs/Xserver/hw/xfree86/common/fourcc.h ${STAGING_INCDIR}/xserver-xqt
}


FILES_${PN} = " ${palmtopdir}/apps/Applications/Xqt.desktop ${palmtopdir}/pics/Xqt/Xqt.png ${bindir}/Xqt "
