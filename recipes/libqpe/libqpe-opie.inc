DESCRIPTION = "Base library for the Qt/Embedded based palmtop environments"
HOMEPAGE = "http://www.trolltech.com"
AUTHOR = "The Trolls"
SECTION = "opie/libs"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "uicmoc-native virtual/libqte2"
PROVIDES = "virtual/libqpe1"
INC_PR = "r7"
S = "${WORKDIR}/library"

inherit palmtop

OE_QMAKE_CXXFLAGS := "${@oe_filter_out('-fno-rtti', '${OE_QMAKE_CXXFLAGS}', d)}"
QMAKE_PROFILES = "library.pro"
EXTRA_QMAKEVARS_PRE += "CONFIG+=LIBQPE_WITHROHFEEDBACK"
EXTRA_QMAKEVARS_POST += "DESTDIR= DEFINES+=LIBQPE_NO_INLINE_IMAGES"

CXXFLAGS_append = " -frtti -DOPIE_NO_ERASE_RECT_HACKFIX -DOPIE_NEW_MALLOC"

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
	oe_runmake MOC=${STAGING_BINDIR_NATIVE}/moc UIC=${STAGING_BINDIR_NATIVE}/uic
}

do_stage() {
	oe_libinstall -so libqpe ${STAGING_LIBDIR}
	# include files already done during do_compile
}

do_install() {
	oe_libinstall -so libqpe ${D}${libdir}

        install -d ${D}${includedir}/qpe \
               ${D}${includedir}/qtopia/private

	for i in ${S}/*.h
	do
		install -m 0644 $i ${D}${includedir}/qpe/`basename $i`
		install -m 0644 $i ${D}${includedir}/qtopia/`basename $i`
		install -m 0644 $i ${D}${includedir}/qtopia/private/`basename $i`
	done
	for i in ${S}/backend/*.h
	do
		install -m 0644 $i ${D}${includedir}/qpe/`basename $i`
		install -m 0644 $i ${D}${includedir}/qtopia/`basename $i`
		install -m 0644 $i ${D}${includedir}/qtopia/private/`basename $i`
	done
	rm -f ${D}${includedir}/qtopia/*_p.h # remove private stuff out of qtopia
}
