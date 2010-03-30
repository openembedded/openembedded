DEPENDS += "python-scons-native"

export TARGET_LINK_HASH_STYLE

scons_do_compile() {
    if [ "${SCONS_FIX_ENV}" = "1" ] ; then
        if grep "toolchain-from-env" ${S}/SConstruct ; then
            echo "Toolchain overrides already applied"
        else
           cat ${STAGING_DATADIR_NATIVE}/scons/toolchain-from-env.SConscript >> ${S}/SConstruct
        fi
    fi

    ${STAGING_BINDIR_NATIVE}/scons ${PARALLEL_MAKE} CXX="${CXX}" PREFIX=${prefix} prefix=${prefix} || \
    oefatal "scons build execution failed."
}

scons_do_install() {
	install -d ${D}${prefix}
        ${STAGING_BINDIR_NATIVE}/scons PREFIX=${D}${prefix} prefix=${D}${prefix} install || \
        oefatal "scons install execution failed."
}

EXPORT_FUNCTIONS do_compile do_install
