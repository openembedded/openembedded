SECTION = "console/utils"
DESCRIPTION = "Tools for performance analysis."
LICENSE = "GPLv2"
RDEPENDS_${PN} = "debianutils"

PR = "r5"

inherit autotools

SRC_URI = "${SOURCEFORGE_MIRROR}/lmbench/lmbench-${PV}.tgz \
	   file://lmbench-run \
	   file://rename-line-binary.patch \
	   file://update-results-script.patch"
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
}

do_install () {
	install -d ${D}${localstatedir}/run/lmbench \
		   ${D}${bindir} ${D}${mandir} ${D}${libdir}/lmbench \
		   ${D}${datadir}/lmbench/scripts
	oe_runmake 'BASE=${D}${prefix}' \
		    -C src install
	mv ${D}${bindir}/line ${D}${bindir}/lm_line
	mv ${D}${prefix}/man/* ${D}${mandir}/
	install -m 0755 ${WORKDIR}/lmbench-run ${D}${bindir}/
	sed -i -e 's,^SHAREDIR=.*$,SHAREDIR=${datadir}/${PN},;' \
	       -e 's,^BINDIR=.*$,BINDIR=${libdir}/${PN},;' \
	       -e 's,^CONFIG=.*$,CONFIG=$SHAREDIR/`$SCRIPTSDIR/config`,;' \
	       ${D}${bindir}/lmbench-run
	install -m 0755 ${S}/scripts/lmbench ${D}${bindir}
	install -m 0755 ${S}/scripts/* ${D}${datadir}/lmbench/scripts
}

FILES_${PN} += "${datadir}/lmbench"
