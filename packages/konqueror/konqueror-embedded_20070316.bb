DESCRIPTION = "KDE Web Browser Konqueror, QtE based Palmtop Environments Edition"
SECTION = "opie/applications"
PRIORITY = "optional"
HOMEPAGE = "http://www.konqueror.org/"
DEPENDS = "openssl libpcre virtual/libqte2 dcopidl-native dcopidl2cpp-native"
LICENSE = "LGPL GPL"
PR = "r6"

# this Konqueror needs the KDEDIR set and the font helvetica installed on the target

inherit autotools

SRC_URI = "http://www.basyskom.de/uploads/175/37/kdenox_snapshot_qt2_20070316.tar.bz2 \
	   file://dont-use-kde-config.patch;patch=1 \
           file://konqe_new_opie.patch;patch=1 \
	   file://konqe-kapplication.patch;patch=1 \
           file://fix_configure.patch;patch=1"
S = "${WORKDIR}/kdenox"

export QMAKE = "${STAGING_BINDIR_NATIVE}/qmake"
export MOC = "${STAGING_BINDIR_NATIVE}/moc"
export UIC = "${STAGING_BINDIR_NATIVE}/uic"
#export exec_prefix = "${palmtopdir}"
#export CXXFLAGS = "-fexceptions -frtti -DKJS_VERBOSE=1 -DQT_THREAD_SUPPORT -DQ_OS_UNIX -DQT_NO_DOM -DENABLE_BOOKMARKS"
export CXXFLAGS = "-fexceptions -frtti -DKJS_VERBOSE=1 -DQT_THREAD_SUPPORT -DQ_OS_UNIX -DENABLE_BOOKMARKS"
export PCRE_CONFIG = "invalid"
# uncomment this for a static build
# EXTRAFLAGS = "-lts"
# EXTRAFLAGS_c7x0 = "-lts -laticore"
export EXTRA_OEMAKE = "EXTRA_LDFLAGS='${EXTRAFLAGS}'"

EXTRA_OECONF = '--prefix=${palmtopdir} \
	--exec-prefix=${palmtopdir} \
#	--includedir=${STAGING_INCDIR} \
	--includedir=/usr/include \
	--with-extra-includes=${STAGING_INCDIR} \
	--with-extra-libs=${STAGING_LIBDIR} \
	--with-qtopia-dir=${OPIEDIR} \
	--with-ssl-version=0.9.7e \
	--with-ssl-dir=${STAGING_DIR_HOST}${layout_exec_prefix} \
	--with-qt-includes=${STAGING_DIR_HOST}/qt2/include \
	--with-qt-libraries=${STAGING_DIR_HOST}/qt2/lib \
	--with-qt-dir=${QTDIR} \
	--enable-fontsubs \
	--with-konq-tmp-prefix=/tmp/kde-cache \
#	--enable-static \
	--disable-static \
	--enable-shared \
	--disable-debug \
	--with-gui=road \
	--with-ipv6-lookup=no \
	--without-xinerama \
#	--disable-scrollbars \
	--disable-selection \
	--disable-bookmarks \
	--with-javascript=static \
	--enable-debug=yes \
	--disable-printing \
#	--enable-pcre \
	--disable-pcre \
	--without-arts \
	--enable-jshostext \
	--disable-selection \
	--enable-final \
	--enable-qt-embedded \
	--enable-rtti-embedded \
	--enable-mt \
	--enable-qpe \
	--enable-qt-mt \
	--enable-fwnewepg=yes \
	--enable-embedded '

do_configure_prepend() {
	cd ${S}
	if ! test -L admin
	then
	    ln -s ../kdelibs/admin admin
	fi
}

do_compile_prepend() {
	perl admin/am_edit
}

do_install_append() {
	install -d ${D}${palmtopdir}/apps/Applications
	install -m 0644 ${FILESDIR}/konqueror.desktop ${D}${palmtopdir}/apps/Applications/
	install -d ${D}${palmtopdir}/pics/konqueror
	install -m 0644 ${FILESDIR}/konqueror.png ${D}${palmtopdir}/pics/konqueror/
	mv ${D}${palmtopdir}/bin ${D}${bindir}
	mv ${D}${bindir}/konqueror ${D}${bindir}/konqueror.bin
	{ echo '#!/bin/sh' ; echo "KDEDIR=/usr exec ${bindir}/konqueror.bin" ; } > ${D}${bindir}/konqueror
	chmod 0755 ${D}${bindir}/konqueror
}

FILES_${PN} = "${palmtopdir} ${datadir} ${bindir}/konqueror* ${libdir}/libkonq*"
