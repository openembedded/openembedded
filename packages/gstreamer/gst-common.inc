SECTION = "multimedia"
PRIORITY = "optional"
LICENSE = "LGPL"
HOMEPAGE = "http://www.gstreamer.net/"

DEFAULT_PREFERENCE = "-1"

inherit autotools pkgconfig

OE_LT_RPATH_ALLOW = "any"
OE_LT_RPATH_ALLOW[export]="1"

do_stage() {
    rm -rf ${STAGE_TEMP}
    mkdir -p ${STAGE_TEMP}
    oe_runmake DESTDIR="${STAGE_TEMP}" install
    if [ -d ${STAGE_TEMP}/${includedir} ]; then
        cp -fpPR ${STAGE_TEMP}/${includedir}/* ${STAGING_INCDIR}
    fi
    for i in $(find ${STAGE_TEMP}/${libdir} -name "*.la")
    do

        destdir=$(dirname $(echo $i | sed -e s,${STAGE_TEMP}/${libdir},${STAGING_LIBDIR},g))
        oenote "Installing library $i to $destdir"
        oe_libinstall -s -so $(basename $i .la) $destdir
    done

    if [ -d ${STAGE_TEMP}/${datadir}/aclocal ]; then
		install -d ${STAGING_DATADIR}/aclocal
		cp -fpPR ${STAGE_TEMP}/${datadir}/aclocal/* ${STAGING_DATADIR}/aclocal
	fi
	rm -rf ${STAGE_TEMP}
}


