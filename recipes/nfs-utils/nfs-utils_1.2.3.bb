DESCRIPTION = "userspace utilities for kernel nfs"
PRIORITY = "optional"
SECTION = "console/network"
LICENSE = "GPLv2"

PR = "r0"

DEPENDS = "util-linux-ng tcp-wrappers libevent"

SRC_URI = "${SOURCEFORGE_MIRROR}/nfs/nfs-utils-${PV}.tar.bz2 \
	file://nfs-utils-uclibc.patch \
	file://shortopt-mode-for-install.patch \
	file://nfsserver \
   "

#PARALLEL_MAKE = ""

# Only kernel-module-nfsd is required here (but can be built-in),
# the nfsd module will pull in the remainder of the dependencies.
RDEPENDS_${PN} = "portmap"
RRECOMMENDS_${PN} = "kernel-module-nfsd"

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
		--disable-uuid \
		--disable-tirpc \
		--with-statedir=/var/lib/nfs"

do_install_append() {
	install -D -m 0755 ${WORKDIR}/nfsserver ${D}${sysconfdir}/init.d/nfsserver

	rm -f ${D}${sbindir}/rpcdebug
}

PACKAGES =+ "nfs-utils-client"
FILES_nfs-utils-client = "${base_sbindir}/*mount.nfs*"

SRC_URI[md5sum] = "1131dc5f27c4f3905a6e7ee0d594fd4d"
SRC_URI[sha256sum] = "5575ece941097cbfa67fbe0d220dfa11b73f5e6d991e7939c9339bd72259ff19"
