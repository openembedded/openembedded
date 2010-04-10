SECTION = "console/utils"
DESCRIPTION = "Tools for performance analysis."
LICENSE = "GPL"
RDEPENDS = "debianutils"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/lmbench/lmbench-${PV}.tgz \
	   file://build.patch;patch=1 \
	   file://lmbench-run"
S = "${WORKDIR}/lmbench-${PV}"

EXTRA_OEMAKE = 'CC="${CC}" AR="${AR}" CFLAGS="${CFLAGS}" \
		LDFLAGS="${LDFLAGS}" LD="${LD}" OS="${TARGET_SYS}" \
		TARGET="${TARGET_OS}" BASE="${prefix}"'

python do_unpack () {
	bb.build.exec_func('base_do_unpack', d)
	bb.build.exec_func('byebk_do_unpack', d)
}

byebk_do_unpack () {
	find ${S}/.. -name BitKeeper -o -name SCCS | xargs rm -rf
}

do_compile () {
	. ${CONFIG_SITE}
	if [ X"$ac_cv_uint" == X"yes" ]; then
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
