DESCRIPTION = "userspace utilities for kernel nfs"
PRIORITY = "optional"
SECTION = "console/network"
LICENSE = "GPL"

PR = "2"

DEPENDS = "e2fsprogs tcp-wrappers libevent"

SRC_URI = "${SOURCEFORGE_MIRROR}/nfs/nfs-utils-${PV}.tar.gz \
	file://nfsserver \
   "

S = "${WORKDIR}/nfs-utils-${PV}/"

PARALLEL_MAKE = ""

# Only kernel-module-nfsd is required here (but can be built-in)  - the nfsd module will
# pull in the remainder of the dependencies.
RDEPENDS = "portmap"
RRECOMMENDS = "kernel-module-nfsd"

INITSCRIPT_NAME = "nfsserver"
# The server has no dependencies at the user run levels, so just put
# it in at the default levels.  It must be terminated before the network
# in the shutdown levels, but that works fine.
INITSCRIPT_PARAMS = "defaults"

inherit autotools update-rc.d

EXTRA_OECONF = "--with-statduser=nobody \
		--enable-nfsv3 \
		--disable-nfsv4 \
		--disable-gss \
		--with-statedir=/var/lib/nfs"

do_ccompile() {
	# UGLY HACK ALERT
	cat ${WORKDIR}/forgotten-defines >> ${S}/support/include/config.h
	oe_runmake 'BUILD=1'
}

INHIBIT_AUTO_STAGE = "1"

do_install() {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/nfsserver ${D}${sysconfdir}/init.d/nfsserver

	install -d ${D}${sbindir}
	install -d ${D}${base_sbindir}
	install -m 0755 ${S}/utils/exportfs/exportfs ${D}${sbindir}/exportfs
	install -m 0755 ${S}/utils/mountd/mountd ${D}${sbindir}/mountd
	install -m 0755 ${S}/utils/mount/mount.nfs ${D}${base_sbindir}/mount.nfs
	install -m 0755 ${S}/utils/nfsd/nfsd ${D}${sbindir}/nfsd
	install -m 0755 ${S}/utils/nfsstat/nfsstat ${D}${sbindir}/nfsstat
	install -m 0755 ${S}/utils/showmount/showmount ${D}${sbindir}/showmount
	install -m 0755 ${S}/utils/statd/statd ${D}${sbindir}/statd

	ln -s ${D}/${base_sbindir}/mount.nfs ${D}/${base_sbindir}/mount.nfs4

	install -d ${D}${mandir}/man8
	install -m 0644 ${S}/utils/exportfs/exportfs.man ${D}${mandir}/man8/exportfs.8
	install -m 0644 ${S}/utils/mountd/mountd.man ${D}${mandir}/man8/mountd.8
	install -m 0644 ${S}/utils/nfsd/nfsd.man ${D}${mandir}/man8/nfsd.8
	install -m 0644 ${S}/utils/nfsstat/nfsstat.man ${D}${mandir}/man8/nfsstat.8
	install -m 0644 ${S}/utils/showmount/showmount.man ${D}${mandir}/man8/showmount.8
	install -m 0644 ${S}/utils/statd/statd.man ${D}${mandir}/man8/statd.8
}

PACKAGES =+ "nfs-utils-client"
FILES_nfs-utils-client = "${base_sbindir}/mount.nfs ${base_sbindir}/mount.nfs4"
