DESCRIPTION = "Base libraries for the Open Palmtop Integrated Environment"
HOMEPAGE = "http://opie.handhelds.org"
SECTION = "opie/libs"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "LGPL"
I18N_FILES = "libopiecore2.ts libopiesecurity2.ts"
DEPENDS = "libqpe-opie sqlite3 libpcap"
PROVIDES = "libopiecore2 libopiedb2 libopiemm2 libopiesecurity2 libopienet2 libopiepim2 libopieui2"

S = "${WORKDIR}/libopie2"

inherit opie

PARALLEL_MAKE = ""

#FIXME: Add machine specific bits here. Best use oe_machinstall and read from a given file

EXTRA_QMAKEVARS_POST = 'DEFINES+=OPIE_NEW_MALLOC \
                        DEFINES+="OPIE_SOUND_FRAGMENT_SHIFT=16" \
			DEFINES+=OPIE_NO_ERASE_RECT_HACKFIX \
			LIBS+=-L${S} LIBS+="-Wl,-rpath-link,${S}"'

EXTRA_QMAKEVARS_PRE = 'ENABLE_SQL_PIM_BACKEND=y'

# uclibc doesn't have backtrace()
python __anonymous () {
    import bb, re
    if (re.match('.*uclibc$', bb.data.getVar('TARGET_OS', d, 1)) != None):
        bb.data.setVar("EXTRA_QMAKEVARS_POST_append", " DEFINES+=OPIE_NO_BACKTRACE ", d)
}

do_compile() {
	install -d ${STAGING_INCDIR}/opie2
	install -d ${STAGING_INCDIR}/opie2/private
	for i in `find . -name "*.h"`
	do
		install -m 0644 $i ${STAGING_INCDIR}/opie2/`basename $i`
	done

	for i in opimcontactsortvector.h opimoccurrence_p.h opimsortvector.h opimtodosortvector.h vobject_p.h opimeventsortvector.h
	do
		install -m 0644 opiepim/private/$i ${STAGING_INCDIR}/opie2/private/
	done

	oe_runmake MOC=${STAGING_BINDIR}/moc UIC=${STAGING_BINDIR}/uic DESTDIR=${S}
}

LIBS = "core2 ui2 db2 mm2 net2 pim2 security2"

# need some special case for uic-created header files here
do_stage() {
        for f in ${LIBS}
	do
		oe_libinstall -so libopie$f ${STAGING_LIBDIR}/
	done

	install -m 0644 ${WORKDIR}/include.pro ${OPIEDIR}/include.pro
	install -m 0644 opiepim/ui/opimrecurrencebase.h ${STAGING_INCDIR}/opie2/
	install -m 0644 opieui/otimepickerbase.h ${STAGING_INCDIR}/opie2/
	install -m 0644 opiepim/core/opimtemplatebase.h ${STAGING_INCDIR}/opie2/
}

do_install() {
	install -d ${D}${palmtopdir}/lib
	for f in ${LIBS}
	do
		oe_libinstall -so libopie$f ${D}${palmtopdir}/lib
	done
}

PACKAGES = "libopiecore2 libopiedb2 libopiesecurity2 libopiemm2 libopienet2 libopiepim2 libopieui2"

FILES_libopiecore2 = "${palmtopdir}/lib/libopiecore2.so*"
FILES_libopiedb2 = "${palmtopdir}/lib/libopiedb2.so*"
FILES_libopiemm2 = "${palmtopdir}/lib/libopiemm2.so*"
FILES_libopienet2 = "${palmtopdir}/lib/libopienet2.so*"
FILES_libopiepim2 = "${palmtopdir}/lib/libopiepim2.so*"
FILES_libopieui2 = "${palmtopdir}/lib/libopieui2.so*"
FILES_libopiesecurity2 = "${palmtopdir}/lib/libopiesecurity2.so*"

#FIXME: Add individual package descriptions and dependencies
