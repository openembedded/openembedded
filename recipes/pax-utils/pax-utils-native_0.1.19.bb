inherit native

require pax-utils_${PV}.bb

do_stage() {
    oe_runmake PREFIX=${STAGING_DIR_HOST}${layout_exec_prefix} install
}

do_install() {
	:
}


SRC_URI[md5sum] = "98f6b9fe17a740a8cc577255422c6103"
SRC_URI[sha256sum] = "3918628e9f2508708a1a28f5ed4cb39d07cbd5711747bbb3ddf63816d056c11e"
