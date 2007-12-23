DESCRIPTION = "Qtopia Core (aka: Qt/Embedded)"
SECTION = "libs"
LICENSE = "GPL"
PRIORITY = "optional"
HOMEPAGE = "http://www.trolltech.com"
DEPENDS = "glib-2.0 freetype dbus-glib tslib"

PR = "r2"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qtopia-core-opensource-src-${PV}.tar.gz \
           file://linux-oe-qmake.conf"

S = "${WORKDIR}/qtopia-core-opensource-src-${PV}"

inherit pkgconfig

# I'm not sure about the globals QTDIR and QTOPIADIR, or if they're even
# needed. On the same issue, I'm not sure what the best place for all the
# Qtopia Core related files is. For now, I've just put the libraries in
# ${libdir}, the includes in ${includedir} etc. Other possibilities are
# to sandbox everything (e.g., in /usr/local/Trolltech or /opt/Qtopia oslt),
# or to put libraries in /usr/lib/qtopia (or /usr/lib/qt4) etc. As said,
# I'm fine with this, but I'm also fine with another solution.

# set QTDIR and QTOPIADIR globally (change QTOPIA dir to QTDIR?)
# This should be the default for other packages:
# export QTDIR = "${STAGING_DIR}/${HOST_SYS}/qt4"
# export QTOPIADIR = "${STAGING_DIR}/${HOST_SYS}/qtopia"
export QTDIR = "${S}"
export QTOPIADIR = "${S}"

# Qmake gets confused by environment variables, as it builds both HOST
# and TARGET objects. The correct compiler settings come from the mkspec
# and are set with the OE_QMAKE_ variables
PARALLEL_MAKE = ""
EXTRA_OEMAKE = " MAKEFLAGS= "

# This stuff could also be done by inheriting qmake, but I didn't want to
# bother with the qmake separation from the Qtopia configure. This separation
# is probably nothing more than a patch on the configure and setting some
# environment variables to use our own qmake/moc/uic, but that's something
# to figure out later.
export OE_QMAKE_CC="${CC}"
export OE_QMAKE_CFLAGS="${CFLAGS}"
export OE_QMAKE_CXX="${CXX}"
export OE_QMAKE_CXXFLAGS="-fno-exceptions ${CXXFLAGS}"
export OE_QMAKE_LDFLAGS="${LDFLAGS}"
export OE_QMAKE_LINK="${CXX}"
export OE_QMAKE_AR="${AR}"
export OE_QMAKE_RANLIB="${RANLIB}"
export OE_QMAKE_STRIP="echo"
export OE_QMAKE_RPATH="-Wl,-rpath-link,"
export OE_QMAKE_INCDIR_QT="${QTDIR}/include"
export OE_QMAKE_LIBDIR_QT="${QTDIR}/lib"
export OE_QMAKE_INCDIR_QTOPIA="${QTOPIADIR}/include"
export OE_QMAKE_LIBDIR_QTOPIA="${QTOPIADIR}/lib"

require qt4_arch.inc
QT_ARCH := "${@qte_arch(d)}"

# FIXME use info.bbclass once it has been commited
QT_ENDIAN = "-little-endian"

# We don't build the examples and demos atm. They're quite big and not used
# frequently, only for testing maybe. Feel free to change and to package
# them separately.
QT_CONFIG_FLAGS = "-release \
	-no-cups -no-accessibility \
	-nomake demos -nomake examples -nomake tools \
	-qt-mouse-tslib"

do_configure() {
	# Install the OE build templates (something which might be done
	# by inheriting qmake)
	for template in linux-oe-g++ linux-uclibc-oe-g++ linux-gnueabi-oe-g++
	do
		install -d ${S}/mkspecs/$template
		install -m 0644 ${WORKDIR}/linux-oe-qmake.conf \
			${S}/mkspecs/$template/qmake.conf
		ln -sf ../linux-g++/qplatformdefs.h \
			${S}/mkspecs/$template/qplatformdefs.h
	done

	# The Qmake Makefile generation doesn't like these environment
	# variables, as they mess up the HOST tools builds
	unset CC
	unset CXX
	unset CFLAGS
	unset CXXFLAGS
	unset LDFLAGS

	# For rationale behind the installation locations, see remark above
	echo yes | ./configure -v \
		-prefix ${prefix} \
		-bindir ${bindir} \
		-libdir ${libdir} \
		-docdir ${docdir}/qtopia \
		-headerdir ${includedir} \
		-plugindir ${datadir}/qtopia/plugins \
		-datadir ${datadir} \
		-translationdir ${datadir}/qtopia/translations \
		-sysconfdir ${sysconfdir} \
		-examplesdir ${bindir}/qtopia/examples \
		-demosdir ${bindir}/qtopia/demos \
		-embedded ${QT_ARCH} ${QT_ENDIAN} -fast \
		-xplatform linux-oe-g++ \
		${QT_CONFIG_FLAGS} \
		-L${STAGING_LIBDIR} -I${STAGING_INCDIR}
}

do_install() {
	oe_runmake install INSTALL_ROOT=${D}

	# These are host binaries, we should only use them in staging
	rm -rf ${D}/${bindir}
	rm -rf ${D}/${datadir}/mkspecs
        
	touch ${D}/${libdir}/fonts/fontdir

        #TT is still new to pkgconfig, so fix it up 
        install -d ${D}${libdir}/pkgconfig
        mv ${D}/${libdir}/*.pc ${D}${libdir}/pkgconfig/
}

# We might want to package all the libraries separately, so you can really
# fine-tune what to install. This is e.g. done in qt4-x11-free_4.1.2.bb.
# What should these packages be called? I'm tempted to call them the same
# as in qt4 version, as the API is supposed to be compatible, e.g.
# libqtcore4 and libqtgui4. This will however conflict if you have QT and
# Qtopia, but this is something you don't want anyway, I guess.
# Another solution is making virtual/libqtfoo4, and DEPENDing on that one
# and let both the PACKAGES in QT and Qtopia PROVIDE these. The packages
# themselves could then be called libqtopiafoo4.
# I'll postpone this discussion by not making separate Qtopia packages.

# Also, I don't package the plugins and translations atm, I don't use them
# and I don't feel like thinking about a sensible separation.

PACKAGES =+ " libqtcore libqtcore-dev libqtcore-dbg \
              libqtxml libqtxml-dev libqtxml-dbg \
              libqtgui libqtgui-dev libqtgui-dbg \
              libqtsql libqtsql-dev libqtsql-dbg \
              libqtnetwork libqtnetwork-dev libqtnetwork-dbg \
              libqtsvg libqtsvg-dev libqtsvg-dbg \
              libqt3support libqt3support-dev libqt3support-dbg \
              qtopia-core-plugins qtopia-core-plugins-dbg\
              "

PACKAGES += " ${PN}-fonts "

# The default included fonts are around 75MB and consist of a number of
# FreeType-renderable fonts as well as QPF (Qtopia Prerendered Fonts).
# As FreeType is generally slow on embedded platforms, and 75MB is
# quite huge, we downsize the fonts dir in the do_install. I've decided
# to include only the QPF (Helvetica and Fixed), amounting to 500KB. This
# also results in tremendously faster application startup time.
FILES_libqtcore += " ${libdir}/fonts/helvetic* ${libdir}/fonts/fixed* ${D}/${libdir}/fonts/fontdir"
FILES_${PN}-fonts = "${libdir}/fonts"

FILES_qtopia-core-plugins += "${datadir}/qtopia/plugins/*/*.so"
FILES_qtopia-core-plugins-dbg += "${datadir}/qtopia/plugins/*/.debug/*.so"

FILES_libqtcore += "${libdir}/libQtCore.so.*"
FILES_libqtxml += "${libdir}/libQtXml.so.*"
FILES_libqtgui += "${libdir}/libQtGui.so.*"
FILES_libqtsql += "${libdir}/libQtSql.so.*"
FILES_libqtnetwork += "${libdir}/libQtNetwork.so.*"
FILES_libqtsvg += "${libdir}/libQtSvg.so.*"
FILES_libqt3support += "${libdir}/libQt3Support.so.*"

FILES_libqtcore-dev += "${libdir}/*QtCore.*"
FILES_libqtxml-dev += "${libdir}/*QtXml.*"
FILES_libqtgui-dev += "${libdir}/*QtGui.*"
FILES_libqtsql-dev += "${libdir}/*QtSql.*"
FILES_libqtnetwork-dev += "${libdir}/*QtNetwork.*"
FILES_libqtsvg-dev += "${libdir}/*QtSvg.*"
FILES_libqt3support-dev += "${libdir}/*Qt3Support.*"

FILES_libqtcore-dbg += "${libdir}/.debug/libQtCore*"
FILES_libqtxml-dbg += "${libdir}/.debug/libQtXml*"
FILES_libqtgui-dbg += "${libdir}/.debug/libQtGui*"
FILES_libqtsql-dbg += "${libdir}/.debug/libQtSql*"
FILES_libqtnetwork-dbg += "${libdir}/.debug/libQtNetwork*"
FILES_libqtsvg-dbg += "${libdir}/.debug/libQtSvg*"
FILES_libqt3support-dbg += "${libdir}/.debug/libQt3Support*"


python populate_packages_prepend() {
        translationdir = bb.data.expand('${datadir}/qtopia/translations/', d)
        do_split_packages(d, translationdir, '^qt_(.*)\.qm$', 'qtopia-translation-%s', 'Qtopia translation for %s', extra_depends='' )
}



STAGE_TEMP = "${WORKDIR}/temp-staging"
do_stage() {
	rm -rf ${STAGE_TEMP}
	mkdir -p ${STAGE_TEMP}
	oe_runmake install INSTALL_ROOT=${STAGE_TEMP}

	cp -pPRf ${STAGE_TEMP}/$includedir/* ${STAGING_INCDIR}

	for i in ${STAGE_TEMP}/${libdir}/*.la
	do
		oe_libinstall -C ${STAGE_TEMP}/${libdir} \
			-so $(basename $i .la) ${STAGING_LIBDIR}
	done

	# Install qmake/moc/uic/rcc in staging (is this needed?)
	install -m 0755 ${STAGE_TEMP}/${bindir}/rcc ${STAGING_BINDIR}
	install -m 0755 ${STAGE_TEMP}/${bindir}/moc ${STAGING_BINDIR}
	install -m 0755 ${STAGE_TEMP}/${bindir}/uic ${STAGING_BINDIR}
	install -m 0755 ${STAGE_TEMP}/${bindir}/qmake ${STAGING_BINDIR}
	# what about mkspecs?

	rm -rf ${STAGE_TEMP}
}

