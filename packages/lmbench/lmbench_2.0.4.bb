SECTION = "console/utils"
DESCRIPTION = "Tools for performance analysis."
LICENSE = "GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"

SRC_URI = "ftp://ftp.bitmover.com/lmbench/lmbench-${PV}.tgz \
	   file://debian.patch;patch=1 \
	   file://exe.patch;patch=1 \
	   file://lmbench-run"
S = "${WORKDIR}/lmbench-${PV}"

EXTRA_OEMAKE = '"CC=${CC}" "AR=${AR}" "CFLAGS=$CFLAGS" \
		"LDFLAGS=${LDFLAGS}" "LD=${LD}" "OS=${TARGET_SYS}" \
		"TARGET=${TARGET_OS}" "O=${S}/bin/${TARGET_SYS}"'

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
	oe_runmake -C src exe
	sed -i -e 's,^SHAREDIR=.*$,SHAREDIR=${datadir}/${PN},;' \
	       -e 's,^BINDIR=.*$,BINDIR=${libdir}/${PN},;' ${WORKDIR}/lmbench-run
}

do_install () {
	oe_runmake 'PREFIX=${D}${prefix}' \
		   'SHAREDIR=${D}${datadir}/${PN}' \
		   'BINDIR=${D}${libdir}/lmbench' install
	install -d ${D}${localstatedir}/lib/lmbench/config \
		   ${D}${localstatedir}/run/lmbench \
		   ${D}${bindir}
	install -m 0755 ${WORKDIR}/lmbench-run ${D}${bindir}/
}
