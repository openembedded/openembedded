DESCRIPTION="Qtopia PDA"
MAINTAINER="Lorn Potter <lpotter@trolltech.com>"
LICENSE="GPL/QPL"
SRC_URI="ftp://ftp.trolltech.com/pub/qtopia/source/qtopia-free-${PV}.tar.gz \
	file://${FILESDIR}/nofreetype.patch;patch=1 \
	file://${FILESDIR}/ft2.patch;patch=1 \
	file://${FILESDIR}/embeddedkonsole.patch;patch=1 \
	file://${FILESDIR}/konsoleEnv.patch;patch=1 \
	file://${FILESDIR}/makefile2.patch;patch=1 \
	file://${FILESDIR}/performance.patch;patch=1 \
	file://${FILESDIR}/qpe.patch;patch=1 \
	file://${FILESDIR}/security.patch;patch=1 \
	file://${FILESDIR}/storage.patch;patch=1"

DEPENDS=base/zlib base/libpng base/jpeg qte-for-qtopia tmake e2fsprogs-libs uicmoc
PROVIDES=virtual/qtopia virtual/libqpe virtual/libqtopia
S="${WORKDIR}/qtopia-free-${PV}"

# strip off leading and trailing whitespace, and made the vars single word
#CXX:="${@bb.data.getVar('CXX', d, 1).strip().split()[-1]}"
#CC:="${@bb.data.getVar('CC', d, 1).strip().split()[-1]}"
#BUILD_CXX:="${@bb.data.getVar('BUILD_CXX', d, 1).strip().split()[-1]}"
#BUILD_CC:="${@bb.data.getVar('BUILD_CC', d, 1).strip().split()[-1]}"
#CFLAGS:="${@bb.data.getVar('CFLAGS', d, 1).strip()}"
#CXXFLAGS:="${@bb.data.getVar('CXXFLAGS', d, 1).strip()}"
#LDFLAGS:="${@bb.data.getVar('LDFLAGS', d, 1).strip()}"

export QPEDIR = ${S}
export QTDIR = ${STAGING_DIR}/target

EXTRA_OECONF_CONFIG =
EXTRA_OECONF_ARCH = -xplatform ${TARGET_OS}-${TARGET_ARCH}-g++
EXTRA_OECONF_ARCH_collie = -xplatform ${TARGET_OS}-sharp-g++
EXTRA_OECONF_ARCH_mnci = -xplatform ${TARGET_OS}-mnci-g++
EXTRA_OECONF = ${EXTRA_OECONF_ARCH} ${EXTRA_OECONF_CONFIG}
EXTRA_OEMAKE = -e

export SYSCONF_CC = ${CC}
export SYSCONF_CXX = ${CXX}
export SYSCONF_LINK = ${CC}
export SYSCONF_SHLIB = ${CC}
export SYSCONF_CFLAGS = ${CFLAGS}
export SYSCONF_CXXFLAGS = ${CXXFLAGS} -DQWS -pipe -fno-exceptions -fno-rtti -DNO_DEBUG -DQT_NO_WIZARD
export SYSCONF_LFLAGS = ${LDFLAGS}
export SYSCONF_MOC = ${STAGING_BINDIR}/moc
export SYSCONF_UIC = ${STAGING_BINDIR}/uic

do_configure() {
	unset CC CXX LD LINK CPP CFLAGS CXXFLAGS LDFLAGS
	if [ "$BUILD_ARCH" = "i686" ]; then
		BUILD_ARCH=x86
	fi
	cd ${S}/src
	echo ./configure -platform ${BUILD_OS}-${BUILD_ARCH}-g++ $EXTRA_OECONF
	./configure -platform ${BUILD_OS}-${BUILD_ARCH}-g++ $EXTRA_OECONF
}


do_compile() {
	unset CC CXX LD LINK CPP CFLAGS CXXFLAGS LDFLAGS
	unset SYSCONF_CFLAGS SYSCONF_CXXFLAGS SYSCONF_LFLAGS SYSCONF_SHLIB CROSS SYSCONF_LFLAGS
	cd ${S}/src
	export SYSCONF_LFLAGS="-L${S}/lib -L${STAGING_LIBDIR} -Wl,-rpath,${S}/lib -Wl,-rpath,${STAGING_LIBDIR} -Wl,-rpath-link,${S}/lib -Wl,-rpath-link,${STAGING_LIBDIR}"
	# Fix to make oe freetype2 available as freetype
	ln -sf  ${STAGING_INCDIR}/freetype2/freetype  ${STAGING_INCDIR}/freetype
	oe_runmake
	# Clean the mess
	rm ${STAGING_INCDIR}/freetype
}

do_stage () {
	cp -a lib/* ${STAGING_LIBDIR}/
	cp -a -R -f --dereference include/qtopia ${STAGING_DIR}/target/include/
	ln -sf ${STAGING_DIR}/target/include/qtopia ${STAGING_DIR}/target/include/qpe
}

do_install () {
	die "no install yet"
#	install -d ${D}/usr/lib/qte2/lib
#	install -m 0755 lib/libqte.so.* ${D}/usr/lib/qte2/lib/
}
