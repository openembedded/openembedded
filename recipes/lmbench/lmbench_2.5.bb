DESCRIPTION = "Tools for performance analysis."
HOMEPAGE = "http://lmbench.sourceforge.net/"
SECTION = "console/utils"
LICENSE = "GPL"
RDEPENDS_${PN} = "debianutils"

PR = "r4"

inherit autotools

SRC_URI = "${SOURCEFORGE_MIRROR}/lmbench/lmbench-${PV}.tgz \
	   file://build.patch \
	   file://lmbench-run"

EXTRA_OEMAKE = 'CC="${CC}" AR="${AR}" CFLAGS="${CFLAGS}" \
		LDFLAGS="${LDFLAGS}" LD="${LD}" OS="${TARGET_SYS}" \
		TARGET="${TARGET_OS}" BASE="${prefix}"'

do_configure() {
	:
}

do_compile () {
	. ${CONFIG_SITE}
	if [ X"$ac_cv_uint" = X"yes" ]; then
		CFLAGS="${CFLAGS} -DHAVE_uint"
	fi
	install -d ${S}/bin/${TARGET_SYS}
	oe_runmake -C src
	sed -i -e 's,^SHAREDIR=.*$,SHAREDIR=${datadir}/${PN},;' \
	       -e 's,^BINDIR=.*$,BINDIR=${libdir}/${PN},;' ${WORKDIR}/lmbench-run
}

do_install () {
        mkdir -p ${D}${libdir}/lmbench
	oe_runmake 'BASE=${D}${prefix}' \
		    -C src install
	install -d ${D}${localstatedir}/lib/lmbench/config \
		   ${D}${localstatedir}/run/lmbench \
		   ${D}${bindir}
	install -m 0755 ${WORKDIR}/lmbench-run ${D}${bindir}/
	mkdir -p ${D}${mandir}
	mv ${D}${prefix}/man/* ${D}${mandir}/
}

SRC_URI[md5sum] = "d5b05498af26d5c09b372caab82a0337"
SRC_URI[sha256sum] = "e7431530a4cf4c44b5068e23454f95765dc0b51e7d98bc2bd70451b17d505bd9"
