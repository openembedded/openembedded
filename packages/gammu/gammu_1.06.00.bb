DESCRIPTION = "GNU All Mobile Managment Utilities"
SECTION = "console/network"
DEPENDS = "bluez-libs"
LICENSE = "GPL"
HOMEPAGE = "http://mwiacek.com/gsm/soft/gammu.html"
AUTHOR = "Marcin Wiacek <marcin@mwiacek.com>"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
PR = "r1"

SRC_URI = "http://www.mwiacek.com/zips/gsm/gammu/stable/1_0x/gammu-${PV}.tar.gz "

EXTRA_OECONF = "--disable-mysql"

inherit autotools pkgconfig

do_compile () {
        oe_runmake shared
}

# FIXME instead of ripping the complete autotools_stage_all, just because
# FIXME gammu needs an additional install target (installshared), it might
# FIXME be more appropriate to a) make the install target in autotools_stage_all
# FIXME customizable or b) alter gammu makefall to make 'install' depend on 'installshared'. :M:
do_stage() {
        rm -rf ${STAGE_TEMP}
        mkdir -p ${STAGE_TEMP}
        oe_runmake DESTDIR="${STAGE_TEMP}" install
	oe_runmake DESTDIR="${STAGE_TEMP}" installshared
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
                        oe_libinstall -so $(basename $i .la) ${STAGING_LIBDIR}
                done
        fi
        if [ -d ${STAGE_TEMP}/${datadir}/aclocal ]; then
                install -d ${STAGING_DATADIR}/aclocal
                cp -fpPR ${STAGE_TEMP}/${datadir}/aclocal/* ${STAGING_DATADIR}/aclocal
        fi
        rm -rf ${STAGE_TEMP}
}

do_install () {
        oe_runmake 'DESTDIR=${D}' installshared
}

PACKAGES =+ "libgammu"

FILES_${PN} = "${bindir}/gammu"
FILES_libgammu = "${libdir}/libGammu.so*"

PACKAGES_DYNAMIC = "gammu-locale-*"

python populate_packages_prepend () {
        help_dir = bb.data.expand('${datadir}/gammu/', d)
        
        do_split_packages(d, help_dir, file_regex='^gammu_(.*)\.txt$', output_pattern='gammu-locale-%s', description='%s translation for Gammu')
}
