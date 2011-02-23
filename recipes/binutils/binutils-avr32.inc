# Extra tasks required when using Atmel's patches to binutils
# See http://avr32linux.org/twiki/bin/view/Main/BinutilsPatches for
# more information

DEPENDS += "autoconf-native automake-native"

do_configure_prepend () {
        if test ${TARGET_ARCH} == avr32; then
            (cd ${S} && autoconf) || die "Error running autoconf"
            for dir in bfd opcodes binutils ld; do
                (cd "${S}/$dir" &&
                 aclocal &&
                 autoconf &&
                 automake &&
                 autoheader) || die "Error reconfiguring $dir"
            done
        fi
}

do_configure_append () {
        if test ${TARGET_ARCH} == avr32; then
						# fix Makefile brokenness due to unmatched single quotes 
						(cd ${B} && sed -i -e "s,'CC=ccache,'CC=${CC}'," Makefile) 
						# *_alias options are not supported in binutils 2.17 and need
						# to be removed
						(cd ${B} && sed -i -e "s,'host_alias=.*',," Makefile)
						(cd ${B} && sed -i -e "s,'build_alias=.*',," Makefile)
						(cd ${B} && sed -i -e "s,'target_alias=*.',," Makefile)

            (cd ${B} && make configure-bfd) || die "Error running 'make configure-bfd'"
            (cd ${B}/bfd && make headers) || die "Error running 'make headers'"
        fi
}
