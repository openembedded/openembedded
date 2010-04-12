DESCRIPTION = "Telepathy framework - GLib library"
HOMEPAGE = "http://telepathy.freedesktop.org/wiki/"
DEPENDS = "glib-2.0 dbus python-native dbus-native"
LICENSE = "LGPL"

SRC_URI = "http://telepathy.freedesktop.org/releases/telepathy-glib/${P}.tar.gz "

inherit autotools pkgconfig

FILES_${PN} += "${datadir}/telepathy \
		${datadir}/dbus-1"

do_stage() {
	#
	# copied autotools_stage_all because telepathy-glib has one lib only built as static
	# so it can not be oe_libinstalled
	#
	rm -rf ${STAGE_TEMP}
	mkdir -p ${STAGE_TEMP}
	oe_runmake DESTDIR="${STAGE_TEMP}" install
	if [ -d ${STAGE_TEMP}/${includedir} ]; then
		cp -fpPR ${STAGE_TEMP}/${includedir}/* ${STAGING_INCDIR}
	fi
	if [ -d ${STAGE_TEMP}/${libdir} ]
	then
		for i in ${STAGE_TEMP}/${libdir}/*.la
		do
			if [ ! -f "$i" ]; then
				cp -fpPR ${STAGE_TEMP}/${libdir}/* ${STAGING_LIBDIR}
				break
			fi
		done
		oe_libinstall -so -C telepathy-glib/.libs libtelepathy-glib ${STAGING_LIBDIR}
	fi
	if [ -d ${STAGE_TEMP}/${datadir}/aclocal ]; then
		install -d ${STAGING_DATADIR}/aclocal
		cp -fpPR ${STAGE_TEMP}/${datadir}/aclocal/* ${STAGING_DATADIR}/aclocal
	fi
	rm -rf ${STAGE_TEMP}
}

SRC_URI[md5sum] = "18b6cae979e438628a1032ff1f12b38e"
SRC_URI[sha256sum] = "f779fbfd30ddc80e15c39f42fc9877725e829dfa19101c3762d6ae809760a3a9"
