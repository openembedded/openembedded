include erlang.inc
DEPENDS += "erlang-native openssl"

SRC_URI += "file://erts-configure.in.patch;patch=1 \
            file://erts-emulator-Makefile.in.patch;patch=1 \
            file://erts-etc-unix-Install.src.patch;patch=1 \
            file://lib-crypto-c_src-Makefile.in.patch;patch=1 \
            file://lib-erl_interface-src-Makefile.in.patch;patch=1 \
            file://Makefile.in.patch;patch=1 \
            "

EXTRA_OEMAKE = "BUILD_CC='${BUILD_CC}'"

EXTRA_OECONF = "--with-ssl=${STAGING_DIR_HOST}${layout_exec_prefix}"

EXTRA_OECONF_append_arm = " --disable-smp-support --disable-hipe"
EXTRA_OECONF_append_armeb = " --disable-smp-support --disable-hipe"
EXTRA_OECONF_append_mipsel = " --disable-smp-support --disable-hipe"
EXTRA_OECONF_append_sh3 = " --disable-smp-support --disable-hipe"
EXTRA_OECONF_append_sh4 = " --disable-smp-support --disable-hipe"

NATIVE_BIN = "${TMPDIR}/work/erlang-native-${PV}-${PR}/otp_src_${UPSTREAM_VERSION}/bin"

do_configure() {

    cd ${S}/erts; autoreconf; cd -

    . ${CONFIG_SITE}

    ac_cv_prog_javac_ver_1_2=no \
    SHLIB_LD='${CC}' \
    oe_runconf

    sed -i -e 's|$(ERL_TOP)/bin/dialyzer|${NATIVE_BIN}/dialyzer --output_plt $@ -pa $(ERL_TOP)/lib/kernel/ebin -pa $(ERL_TOP)/lib/stdlib/ebin|' lib/dialyzer/src/Makefile
}

do_compile() {
    TARGET=${TARGET_SYS} \
    PATH=${NATIVE_BIN}:$PATH \
    oe_runmake noboot
}

do_install() {
    TARGET=${TARGET_SYS} \
    PATH=${NATIVE_BIN}:$PATH \
    oe_runmake 'INSTALL_PREFIX=${D}' install
    for f in erl start
        do sed -i -e 's:ROOTDIR=.*:ROOTDIR=/usr/lib/erlang:' \
        	${D}/usr/lib/erlang/erts-*/bin/$f ${D}/usr/lib/erlang/bin/$f
    done
}

def get_erlang_libs(d):
    import os, bb
    install_root = bb.data.getVar('D', d, 1)
    libdir = bb.data.getVar('libdir', d, 1)[1:]
    libs = ["${bindir}/dialyzer", "${libdir}/erlang/bin/dialyzer"]
    erlang_lib = os.path.join(install_root, libdir, "erlang/lib")
    for fname in os.listdir(erlang_lib):
        if not "-" in fname: continue
        if fname.startswith("compiler-"): continue
        if fname.startswith("kernel-"): continue
        if fname.startswith("sasl-"): continue
        if fname.startswith("stdlib-"): continue
        if fname.startswith("tools-"): continue
        libs.append(os.path.join("${libdir}", "erlang/lib", fname))
    libs.sort()
    return libs

FILES_${PN}-dbg += " ${libdir}/erlang/bin/.debug ${libdir}/erlang/*/bin/.debug ${libdir}/erlang/lib/*/bin/.debug"
FILES_${PN}-libs += " ${@' '.join(get_erlang_libs(d))}"
PACKAGES =+ "${PN}-libs"

SRC_URI[md5sum] = "1fe3707d9bed898bc51444cb529fdd79"
SRC_URI[sha256sum] = "d5a8530dfee0b2348c4ad0107409fa73ac3233f31e2300ece625a2abd9eb4da7"
