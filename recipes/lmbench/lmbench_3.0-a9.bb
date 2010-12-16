SECTION = "console/utils"
DESCRIPTION = "Tools for performance analysis."
LICENSE = "GPL"
RDEPENDS_${PN} = "debianutils"

PR = "r2"

inherit autotools

SRC_URI = "${SOURCEFORGE_MIRROR}/lmbench/lmbench-${PV}.tgz \
	   file://lmbench-run"
SRC_URI[md5sum] = "b3351a3294db66a72e2864a199d37cbf"
SRC_URI[sha256sum] = "cbd5777d15f44eab7666dcac418054c3c09df99826961a397d9acf43d8a2a551"

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
	install -m 0755 ${S}/scripts/lmbench ${D}${bindir}
	install -d ${D}${datadir}/lmbench/scripts
	install -m 0755 ${S}/scripts/* ${D}${datadir}/lmbench/scripts
}

FILES_${PN} += "${datadir}/lmbench"
