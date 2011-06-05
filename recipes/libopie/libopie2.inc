DESCRIPTION = "Base libraries for the Open Palmtop Integrated Environment"
HOMEPAGE = "http://opie.handhelds.org"
SECTION = "opie/libs"
LICENSE = "LGPL"
I18N_FILES = "libopiecore2.ts libopiesecurity2.ts"
DEPENDS = "libqpe-opie libpcap sqlite3 bluez-libs"
PROVIDES = "libopiecore2 libopiedb2 libopiemm2 libopiesecurity2 libopienet2 libopiepim2 libopieui2"

S = "${WORKDIR}/libopie2"

inherit opie

PARALLEL_MAKE = ""

#FIXME: Add machine specific bits here. Best use oe_machinstall and read from a given file

EXTRA_QMAKEVARS_POST += 'DEFINES+=OPIE_NEW_MALLOC \
                        DEFINES+="OPIE_SOUND_FRAGMENT_SHIFT=16" \
			DEFINES+=OPIE_NO_ERASE_RECT_HACKFIX \
			LIBS+=-L${S} LIBS+="-Wl,-rpath-link,${S}" \
			INCLUDEPATH+=${S}/include'

ENABLE_SQL_PIM_BACKEND = "y"
# NOTE: Machines with too little amount of flash may want to disable SQL backend support
# (known not to fit in 16MB).
#ENABLE_SQL_PIM_BACKEND_smallmachine = "n"
EXTRA_QMAKEVARS_PRE += 'ENABLE_SQL_PIM_BACKEND=${ENABLE_SQL_PIM_BACKEND}'

MODULES = "opiecore opiedb opiemm opienet opiepim opiesecurity opieui opiebluez"
LIBS    = "core2    db2    mm2    net2    pim2    security2    ui2 bluez2"
PRIVATE = "opimcontactsortvector.h opimoccurrence_p.h opimsortvector.h \
           opimtodosortvector.h vobject_p.h opimeventsortvector.h opimmemosortvector.h"

# uclibc doesn't have backtrace()
python __anonymous () {
    import bb, re
    if (re.match('.*uclibc$', bb.data.getVar('TARGET_OS', d, 1)) != None):
        bb.data.setVar("EXTRA_QMAKEVARS_POST_append", " DEFINES+=OPIE_NO_BACKTRACE ", d)
}

do_compile() {
	install -d ${S}/include/opie2
	for module in ${MODULES}
	do
		cd $module
		for i in `find . -name "*.h"`
		do
			filenm=`echo $i | sed 's!^\./!!'`
			ln -sf ../../$module/$filenm ${S}/include/opie2/
		done
		cd ..
	done

	install -d ${S}/include/opie2/private
	for header in ${PRIVATE}
	do
		ln -sf ../../../opiepim/private/$header ${S}/include/opie2/private
	done

	oe_runmake MOC=${STAGING_BINDIR_NATIVE}/moc UIC=${STAGING_BINDIR_NATIVE}/uic DESTDIR=${S}
}

do_install() {
	install -d ${D}${libdir}
	for f in ${LIBS}
	do
		oe_libinstall -so libopie$f ${D}${libdir}
	done

	install -m 0644 ${WORKDIR}/include.pro ${OPIEDIR}/include.pro

	install -d ${D}${includedir}/opie2/
	for module in ${MODULES}
	do
		cd $module
		for i in `find . -name "*.h"`
		do
			if [[ $i != ./private/* ]] ; then
				install -m 0644 $i ${D}${includedir}/opie2/`basename $i`
			fi
		done
		cd ..
	done
	# Remove some headers we don't want packaged
	rm ${D}${includedir}/opie2/stable_pch.h
	rm ${D}${includedir}/opie2/ofileselector_p.h
	rm ${D}${includedir}/opie2/okeyconfigwidget_p.h
	rm ${D}${includedir}/opie2/okeyconfigmanager_p.h
	rm ${D}${includedir}/opie2/ima_rw.h
	rm ${D}${includedir}/opie2/udp_ports.h
	rm ${D}${includedir}/opie2/odevice_*.h
}

PACKAGES_prepend = " libopiecore2 libopiedb2 libopiesecurity2 libopiemm2 libopienet2 libopiepim2 libopieui2 libopiebluez2 "

DESCRIPTION_libopiecore2 = "Opie Development Platform 1.x Core Library"
FILES_libopiecore2 = "${libdir}/libopiecore2.so.*"
DESCRIPTION_libopiedb2 = "Opie Development Platform 1.x Database Library"
FILES_libopiedb2 = "${libdir}/libopiedb2.so.*"
DESCRIPTION_libopiemm2 = "Opie Development Platform 1.x Multimedia Library"
FILES_libopiemm2 = "${libdir}/libopiemm2.so.*"
DESCRIPTION_libopienet2 = "Opie Development Platform 1.x Network Library"
FILES_libopienet2 = "${libdir}/libopienet2.so.*"
DESCRIPTION_libopiepim2 = "Opie Development Platform 1.x PIM Library"
FILES_libopiepim2 = "${libdir}/libopiepim2.so.*"
DESCRIPTION_libopieui2 = "Opie Development Platform 1.x User Interface Library"
FILES_libopieui2 = "${libdir}/libopieui2.so.*"
DESCRIPTION_libopiesecurity2 = "Opie Development Platform 1.x Security Library"
FILES_libopiesecurity2 = "${libdir}/libopiesecurity2.so.*"
DESCRIPTION_libopiebluez2 = "Opie Development Platform 1.x Bluetooth Library"
FILES_libopiebluez2 = "${libdir}/libopiebluez2.so.*"

