include erlang.inc

inherit native

PR = "r1"

# EXTRA_OEMAKE = 'OTP_SMALL_BUILD=true'
EXTRA_OECONF = '--without-ssl'

do_configure() {
    TARGET=${HOST_SYS} \
    ac_cv_prog_javac_ver_1_2=no \
    ac_cv_prog_javac_ver_1_5=no \
	oe_runconf
}

do_compile_prepend() {
    export TARGET=${HOST_SYS}
}

do_stage_prepend() {
    export TARGET=${HOST_SYS}
}

do_install_prepend() {
    export TARGET=${HOST_SYS}
}

SRC_URI[md5sum] = "b3db581de6c13e1ec93d74e54a7b4231"
SRC_URI[sha256sum] = "f0964946f3cdd224500a7a6df1c2ee2bf9ef2d3684ab82c2dd6c22b98986bc80"
