DESCRIPTION = "Lsof is a Unix-specific diagnostic tool. \
Its name stands for LiSt Open Files, and it does just that."
SECTION = "devel"
LICENSE = "BSD"

PR = "r2"

SRC_URI = "ftp://lsof.itap.purdue.edu/pub/tools/unix/lsof/lsof_${PV}.tar.bz2;name=lsof483tarbz2"
SRC_URI[lsof483tarbz2.md5sum] = "8f731a6251b8c0143d585df0d5ca779e"
SRC_URI[lsof483tarbz2.sha256sum] = "b89f930bbe36b970e3cd070b9860ee701d8c7285ffedf2fbcec0e5fa3cb1f544"

LOCALSRC = "${WORKDIR}/lsof_${PV}/lsof_${PV}_src.tar"
S = "${WORKDIR}/lsof_${PV}_src"

# The tar.bz2 file contains another tar.
do_unpackpost() {
	tar x --no-same-owner -f ${LOCALSRC} -C ${WORKDIR}
}
addtask unpackpost before do_patch after do_unpack

export LSOF_OS = "${TARGET_OS}"
LSOF_OS_libc-uclibc = "linux"
LSOF_OS_libc-glibc = "linux"
export LSOF_INCLUDE = "${STAGING_INCDIR}"

do_configure () {
	yes | ./Configure ${LSOF_OS}
}

export I = "${STAGING_INCDIR}"
export L = "${STAGING_INCDIR}"
export EXTRA_OEMAKE = ""

do_compile () {
	oe_runmake 'CC=${CC}' 'CFGL=${LDFLAGS} -L./lib -llsof' 'DEBUG=' 'INCL=${CFLAGS}' \
	'RANLIB=${RANLIB} liblsof.a'
}

do_install () {
	install -d ${D}${sbindir} ${D}${mandir}/man8
	install -m 4755 lsof ${D}${sbindir}/lsof
	install -m 0644 lsof.8 ${D}${mandir}/man8/lsof.8
}
