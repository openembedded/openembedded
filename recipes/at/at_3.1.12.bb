DESCRIPTION = "Delayed job execution and batch processing."
SECTION = "base"
LICENSE = "GPL"
DEPENDS = "flex-native flex"
RCONFLICTS_${PN} = "atd"
RREPLACES_${PN} = "atd"

PR = "r3"

SRC_URI = " \
	${DEBIAN_MIRROR}/main/a/at/at_${PV}.orig.tar.gz \
	file://at-3.1.12-0001-configure.ac-remove-manual-compiler-check-with-AC_TR.patch \
	file://at-3.1.12-0002-configure.ac-convert-AC_TRY_COMPILE-AC_COMPILE_IFELS.patch \
	file://at-3.1.12-0003-Makefile.in-add-LDFLAGS-to-linking-stage.patch \
	file://at-3.1.12-0005-Makefile.in-replace-IROOT-by-DESTDIR.patch \
	file://at-3.1.12-0006-Makefile.in-make-install-fix.patch \
	file://at-3.1.12-0007-getloadavg-fix.patch \
	file://at-parallel-make-fix.patch \
	file://init \
	"
inherit autotools update-rc.d

INITSCRIPT_NAME = "atd"

EXTRA_OECONF += " --with-jobdir=/var/spool/cron/atjobs \
	     --with-atspool=/var/spool/cron/atspool \
	     --with-daemon_username=root \
	     --with-daemon_groupname=root \
	     "
EXTRA_OEMAKE += "docdir=${docdir}"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/atd
}

SRC_URI[md5sum] = "1e67991776148fb319fd77a2e599a765"
SRC_URI[sha256sum] = "7c55c6ab4fbe8add9e68f31b2b0ebf3fe805c9a4e7cfb2623a3d8a4789cc18f3"
