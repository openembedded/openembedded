include erlang.inc

inherit native

# EXTRA_OEMAKE = 'OTP_SMALL_BUILD=true'
EXTRA_OECONF = '--without-ssl'

do_configure() {
    TARGET=${HOST_SYS} \
    ac_cv_prog_javac_ver_1_2=no \
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

SRC_URI[md5sum] = "1fe3707d9bed898bc51444cb529fdd79"
SRC_URI[sha256sum] = "d5a8530dfee0b2348c4ad0107409fa73ac3233f31e2300ece625a2abd9eb4da7"
