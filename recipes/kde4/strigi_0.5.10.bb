inherit qt4x11 cmake

PR = "r1"

DEPENDS += "clucene-core pidgin expat gamin"

SRC_URI = "${SOURCEFORGE_MIRROR}/strigi/strigi-${PV}.tar.bz2"

EXTRA_OECMAKE = "-DENABLE_FAM:BOOL=ON \
                 -DENABLE_EXPAT:BOOL=ON \
                 -DENABLE_INOTIFY:BOOL=ON \
                 -DGAMIN_LIBARIES:STRING=${STAGING_LIBDIR} \
                 -DGAMIN_LIBRARIES:STRING=${STAGING_LIBDIR} \
		"

FILES_${PN} += "${datadir}/dbus-1 \
               "
AUTOTOOLS_STAGE_PKGCONFIG = "1"
do_stage() {
        autotools_stage_all
}


