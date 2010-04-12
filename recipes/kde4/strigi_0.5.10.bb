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



SRC_URI[md5sum] = "cfaa2114ea27f2a00e6773c374e98ec4"
SRC_URI[sha256sum] = "3851f803de3759490073c1d682d018592b010437b9ac2b85394eaddc63621faf"
