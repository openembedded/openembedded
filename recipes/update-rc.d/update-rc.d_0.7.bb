SECTION = "base"
PRIORITY = "standard"
DESCRIPTION = "Manage symlinks in /etc/rcN.d"
LICENSE = "GPLv2+"
S = "${WORKDIR}"
# S = "${WORKDIR}/update-rc.d"
INHIBIT_DEFAULT_DEPS = "1"
PR = "r2"

BBCLASSEXTEND = "native"

SRC_URI = "file://update-rc.d \
           file://add-verbose.patch"

PACKAGE_ARCH = "all"

do_compile() {
}

do_stage() {
	install -m 0755 ${S}/update-rc.d ${STAGING_BINDIR_NATIVE}/
}

do_install() {
	install -d ${D}${sbindir}
	install -m 0755 ${S}/update-rc.d ${D}${sbindir}/update-rc.d
}

NATIVE_INSTALL_WORKS = "1"
