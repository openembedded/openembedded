DESCRIPTION = "GNU All Mobile Managment Utilities"
SECTION = "console/network"
DEPENDS = "bluez-libs cmake-native python mysql"
RDEPENDS_python-${PN} = "python-core"
LICENSE = "GPL"
HOMEPAGE = "http://www.gammu.org/"
PR = "r0"

SRC_URI = "http://dl.cihar.com/gammu/releases/gammu-${PV}.tar.bz2"

inherit distutils-common-base cmake

do_configure() {
    cd ${S}
    sed -i 's@^cmake [^$]*\$@cmake -DCMAKE_FIND_ROOT_PATH=${STAGING_DIR_TARGET} $@' configure
    sed -i 's@\${PYTHON_SITEDIR}@${PYTHON_SITEPACKAGES_DIR}@g' python/gammu/CMakeLists.txt
    ./configure --prefix=${prefix} --enable-shared --enable-backup
}

do_stage() {
    autotools_stage_all
}

# gammu has a non-standard uninstalled .pc file, which confuses pkgconfig.bbclass.
# Replace it by custom do_stage_append():
#do_stage_append () {
#	install -d ${PKG_CONFIG_DIR}
#	cat build-configure/cfg/gammu.pc > ${PKG_CONFIG_DIR}/gammu.pc
#}

PACKAGES =+ "${PN}-smsd libgammu libgsmsd python-${PN}"

FILES_${PN} = "${bindir}/gammu ${bindir}/jadmaker ${sysconfdir}/bash_completion.d/gammu"
FILES_${PN}-smsd = "${bindir}/gammu-smsd*"
FILES_${PN}-dev += "${bindir}/gammu-config ${libdir}/*.so"
FILES_${PN}-dbg += "${bindir}/.debug ${libdir}/.debug ${PYTHON_SITEPACKAGES_DIR}/gammu/.debug"
FILES_libgammu = "${libdir}/libGammu.so.*"
FILES_libgsmsd = "${libdir}/libgsmsd.so.*"
FILES_python-${PN} = "${PYTHON_SITEPACKAGES_DIR}/gammu/*.??"
