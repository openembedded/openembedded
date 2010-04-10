DESCRIPTION = "Xfce4 development tools"
SECTION = "x11/libs"
LICENSE = "GPL"

inherit xfce
XFCE_VERSION = 4.4.2

do_stage() {
	install -d ${STAGING_DATADIR}/aclocal
	install -m 644 m4macros/*.m4 ${STAGING_DATADIR}/aclocal/
}

FILES_${PN}-dev += " ${datadir}/xfce4/dev-tools/m4macros/*.m4"

SRC_URI[md5sum] = "7d09d161efc7ef86b3b48791d98c8ae8"
SRC_URI[sha256sum] = "1e7a506f08c8a4f368dd18648006ba3934a94eb96fd4545f5303d46aeae9cc3e"
