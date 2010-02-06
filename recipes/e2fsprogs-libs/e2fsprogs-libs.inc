DESCRIPTION = "EXT2 Filesystem Utilities"
LICENSE = "GPL"
SECTION = "base"
PRIORITY = "optional"
DEPENDS = "util-linux-ng"

inherit autotools_stage gettext

SRC_URI = "${SOURCEFORGE_MIRROR}/e2fsprogs/e2fsprogs-libs-${PV}.tar.gz \
           file://configure.patch;patch=1 \
           file://compile-subst.patch;patch=1 \
           file://m4.patch;patch=1"

S = "${WORKDIR}/e2fsprogs-libs-${PV}"
FILES_e2fsprogs-libs-dev_append = " ${datadir}/et ${datadir}/ss"
FILES_${PN} = "${bindir}"
EXTRA_OECONF = "--disable-libblkid --disable-libuuid"

python populate_packages_prepend () {
	e2fs_libdir = bb.data.expand('${libdir}', d)
	e2fs_libdir_dbg = bb.data.expand('${libdir}/.debug', d)
	do_split_packages(d, e2fs_libdir, '^lib(.*)\.so$', 'lib%s-dev', 'e2fsprogs-libs %s development package', extra_depends='${PN}-dev', allow_links=True)
	do_split_packages(d, e2fs_libdir, '^lib(.*)\.la$', 'lib%s-dev', 'e2fsprogs-libs %s development package', extra_depends='${PN}-dev')
	do_split_packages(d, e2fs_libdir, '^lib(.*)\.a$', 'lib%s-dev', 'e2fsprogs-libs %s development package', extra_depends='${PN}-dev')
	do_split_packages(d, e2fs_libdir, '^lib(.*)\.so\.*', 'lib%s', 'e2fsprogs-libs %s library', extra_depends='', allow_links=True)
}

do_stage () {
        for i in libcom_err libss; do
                oe_libinstall -a -C lib $i ${STAGING_LIBDIR}
        done
        install -d ${STAGING_INCDIR}/et \
                   ${STAGING_INCDIR}/ss
        install -m 0644 lib/et/com_err.h ${STAGING_INCDIR}/et/
        install -m 0644 lib/ss/ss.h ${STAGING_INCDIR}/ss/
        install -m 0644 lib/ss/ss_err.h ${STAGING_INCDIR}/ss/
}

# avoid requiring unsupported util-linux-ng for nylon, provide uuid for others...
DEPENDS_nylon = ""
EXTRA_OECONF_nylon = ""
do_stage_append_nylon() {
        install -d ${STAGING_INCDIR}/uuid
        install -m 0644 lib/uuid/uuid.h ${STAGING_INCDIR}/uuid/
        install -m 0644 lib/uuid/libuuid.a ${STAGING_LIBDIR}/
}
