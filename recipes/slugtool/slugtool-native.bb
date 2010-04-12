SECTION = "unknown"
require slugtool.bb
inherit native

PACKAGES = ""

do_stage () {
	install -m 0755 slugtool ${STAGING_BINDIR}/
}

SRC_URI[md5sum] = "d83e00e9c691984f36cb421d84873bc7"
SRC_URI[sha256sum] = "0a2080a48f8a52d10d49aa78a66027205920b76c8e901d07fb040759191aad9e"
