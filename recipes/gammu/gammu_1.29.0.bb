DESCRIPTION = "GNU All Mobile Managment Utilities"
SECTION = "console/network"
DEPENDS = "bluez-libs cmake-native curl python mysql"
RDEPENDS_python-${PN} = "python-core"
LICENSE = "GPL"
HOMEPAGE = "http://www.gammu.org/"
PR = "r0"

SRC_URI = "http://dl.cihar.com/gammu/releases/gammu-${PV}.tar.bz2"

inherit distutils-common-base cmake

# FIXME: Ugly!
PYTHON_VERSION = "2.6"
do_configure() {
    cd ${S}
    sed -i 's@^cmake [^$]*\$@cmake -DCMAKE_FIND_ROOT_PATH=${STAGING_DIR_TARGET} -DPYTHON_INCLUDE_DIR=${STAGING_INCDIR}/python${PYTHON_VERSION} $@' configure
    sed -i 's@\${PYTHON_SITEDIR}@${PYTHON_SITEPACKAGES_DIR}@g' python/gammu/CMakeLists.txt
    ./configure --prefix=${prefix} --enable-shared --enable-backup
}

PACKAGES =+ "${PN}-smsd libgammu libgsmsd python-${PN}"

FILES_${PN} = "${bindir}/gammu ${bindir}/jadmaker ${sysconfdir}/bash_completion.d/gammu"
FILES_${PN}-smsd = "${bindir}/gammu-smsd*"
FILES_${PN}-dev += "${bindir}/gammu-config ${libdir}/*.so"
FILES_${PN}-dbg += "${bindir}/.debug ${libdir}/.debug ${PYTHON_SITEPACKAGES_DIR}/gammu/.debug"
FILES_libgammu = "${libdir}/libGammu.so.*"
FILES_libgsmsd = "${libdir}/libgsmsd.so.*"
FILES_python-${PN} = "${PYTHON_SITEPACKAGES_DIR}/gammu/*.??"

SRC_URI[md5sum] = "5a860f37519fab3d2e7a42349b413738"
SRC_URI[sha256sum] = "0f7c3122e5f5e246b3ce7fb128b42c1d679ebb3f11f805ea17f1ba86400e1bbf"
