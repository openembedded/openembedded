DESCRIPTION = "Base library for the Qt/Embedded based palmtop environments"
HOMEPAGE = "http://www.trolltech.com"
AUTHOR = "The Trolls"
SECTION = "opie/libs"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
DEPENDS = "uicmoc-native virtual/libqte2"
PROVIDES = "virtual/libqpe1"

S = "${WORKDIR}/library"

inherit palmtop

QMAKE_PROFILES = "library.pro"
EXTRA_QMAKEVARS_PRE += "CONFIG+=LIBQPE_WITHROHFEEDBACK"
EXTRA_QMAKEVARS_POST += "DESTDIR= DEFINES+=LIBQPE_NO_INLINE_IMAGES"

CXXFLAGS_append = " -DOPIE_NO_ERASE_RECT_HACKFIX -DOPIE_NEW_MALLOC"
CXXFLAGS_append_c7x0 =  " -DOPIE_NO_WINDOWED "
CXXFLAGS_append_tosa =  " -DOPIE_NO_WINDOWED "
CXXFLAGS_append_spitz = " -DOPIE_NO_WINDOWED "
CXXFLAGS_append_akita = " -DOPIE_NO_WINDOWED "

do_compile_prepend_mnci () {
	ln -s custom-ramses.h custom.h
}

do_compile() {
        mkdir -p ${STAGING_INCDIR}/qpe \
                 ${STAGING_INCDIR}/qtopia \
                 ${STAGING_INCDIR}/opie \
                 ${STAGING_INCDIR}/opie2 \
                 ${STAGING_INCDIR}/qtopia/private
	for i in ${S}/*.h
	do
		install -m 0644 $i ${STAGING_INCDIR}/qpe/`basename $i`
		install -m 0644 $i ${STAGING_INCDIR}/qtopia/`basename $i`
		install -m 0644 $i ${STAGING_INCDIR}/qtopia/private/`basename $i`
	done
	for i in ${S}/backend/*.h
	do
		install -m 0644 $i ${STAGING_INCDIR}/qpe/`basename $i`
		install -m 0644 $i ${STAGING_INCDIR}/qtopia/`basename $i`
		install -m 0644 $i ${STAGING_INCDIR}/qtopia/private/`basename $i`
	done
	rm -f ${STAGING_INCDIR}/qtopia/*_p.h # remove private stuff out of qtopia
	oe_runmake MOC=${STAGING_BINDIR}/moc UIC=${STAGING_BINDIR}/uic
}

do_stage() {
	oe_libinstall -so libqpe ${STAGING_LIBDIR}
	# include files already done during do_compile
}

do_install() {
	oe_libinstall -so libqpe ${D}${palmtopdir}/lib
}

PACKAGES = "libqpe1"
FILES_libqpe1 = "${palmtopdir}/lib"
PACKAGE_ARCH = "${MACHINE_ARCH}"
