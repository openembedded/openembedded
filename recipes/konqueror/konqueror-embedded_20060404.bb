DESCRIPTION = "KDE Web Browser Konqueror, QtE based Palmtop Environments Edition"
SECTION = "opie/applications"
PRIORITY = "optional"
HOMEPAGE = "http://www.konqueror.org/"
DEPENDS = "openssl libpcre virtual/libqte2 dcopidl-native dcopidl2cpp-native"
LICENSE = "LGPL GPL"
PR = "r3"

# this Konqueror needs the KDEDIR set and the font helvetica installed on the target

inherit autotools

SRC_URI = "svn://anonsvn.kde.org/home/kde/tags/KDE/3.5.1;module=kdelibs;date=${PV} \
           svn://anonsvn.kde.org/home/kde/trunk;module=kdenox;date=${PV} \
           file://gcc4.patch;patch=1 \
	   file://dont-use-kde-config.patch;patch=0"
# uncomment this for a static build
#          file://inject-extraflags.patch;patch=1"
S = "${WORKDIR}/kdenox"

export QMAKE = "${STAGING_BINDIR_NATIVE}/qmake"
export MOC = "${STAGING_BINDIR_NATIVE}/moc"
export UIC = "${STAGING_BINDIR_NATIVE}/uic"
#export exec_prefix = "${palmtopdir}"
export CXXFLAGS = "-fexceptions -frtti -DKJS_VERBOSE=1 -DQT_THREAD_SUPPORT -DQ_OS_UNIX -DQT_NO_DOM -DENABLE_BOOKMARKS"
export PCRE_CONFIG = "invalid"
# uncomment this for a static build
# EXTRAFLAGS = "-lts"
# EXTRAFLAGS_c7x0 = "-lts -laticore"
export EXTRA_OEMAKE = "EXTRA_LDFLAGS='${EXTRAFLAGS}'"

EXTRA_OECONF = '--prefix=${palmtopdir} \
	--exec-prefix=${palmtopdir} \
	--includedir=${STAGING_INCDIR} \
	--with-extra-includes=${STAGING_INCDIR} \
	--with-extra-libs=${STAGING_LIBDIR} \
	--with-ssl-version=0.9.7e \
	--with-ssl-dir=${STAGING_DIR_HOST}${layout_exec_prefix} \
	--with-qt-includes=${STAGING_DIR_HOST}/qt2/include \
	--with-qt-libraries=${STAGING_DIR_HOST}/qt2/lib \
	--enable-fontsubs \
	--with-konq-tmp-prefix=/tmp/kde-cache \
#	--enable-static \
	--disable-static \
	--enable-shared \
	--disable-debug \
	--with-gui=road \
	--with-ipv6-lookup=no \
	--without-xinerama \
	--disable-scrollbars \
	--disable-selection \
	--disable-bookmarks \
	--with-javascript=static \
	--enable-debug=yes \
	--disable-printing \
	--enable-pcre \
	--without-arts \
	--enable-jshostext \
	--disable-selection \
	--enable-final \
	--enable-qt-embedded \
	--enable-rtti-embedded \
	--enable-mt \
	--enable-qt-mt\
	--enable-fwnewepg=yes \
	--enable-embedded '

do_configure_prepend() {
	cd ${S}
	if ! test -L admin
	then
	    ln -s ../kdelibs/admin admin
	fi
	make -f Makefile.cvs
}

do_compile_prepend() {
	perl admin/am_edit
}

FILES_${PN} = "${palmtopdir} ${datadir}"

