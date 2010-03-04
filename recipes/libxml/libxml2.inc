DESCRIPTION = "GNOME XML Parser library"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "MIT"
DEPENDS_virtclass-native = "python-native"

SRC_URI = "ftp://xmlsoft.org/libxml2/libxml2-${PV}.tar.gz;name=archive"
S = "${WORKDIR}/${BPN}-${PV}"

INC_PR = "r5"

BBCLASSEXTEND = "native"

inherit autotools pkgconfig binconfig

EXTRA_OECONF = "\
 --without-debug \
 --without-legacy \
 --with-catalog \
 --with-docbook \
 --with-c14n"

EXTRA_OECONF_append = " --without-python"
EXTRA_OECONF_append_virtclass-native = " --with-python=${PYTHON_DIR}"

export LDFLAGS += "-ldl"

do_install_append() {
 	install -m 0644 libxml.m4 ${STAGING_DATADIR}/aclocal/
	#this is need it by php during its install
	install -m 0755 xml2-config ${STAGING_BINDIR_CROSS}
}
do_install_append_virtclass-native() {
	:
}

DEBIANNAME_${PN} = "libxml2"

PACKAGES =+ "${PN}-utils"
FILES_${PN} = "${libexecdir}/* ${libdir}/lib*${SOLIBS} \
            ${sysconfdir} ${sharedstatedir} ${localstatedir} \
            ${base_libdir}/*${SOLIBS} \
            ${datadir}/${PN} ${libdir}/${PN}/* \
            ${datadir}/pixmaps ${datadir}/applications \
            ${datadir}/idl ${datadir}/omf ${datadir}/sounds \
            ${libdir}/bonobo/servers"

FILES_${PN}-dev += "${bindir}/*-config"
FILES_${PN}-utils = "${bindir}/xmllint ${bindir}/xmlcatalog ${libdir}/*.sh"
