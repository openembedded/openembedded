# Extra tasks required when using Atmel's patches to binutils
# See http://avr32linux.org/twiki/bin/view/Main/BinutilsPatches for
# more information


do_avr32_reconf () {
        if test ${TARGET_ARCH} == avr32; then
            (cd ${S} && autoconf2.13) || die "Error running autoconf"
            for dir in bfd opcodes binutils ld; do
                (cd "${S}/$dir" &&
                 aclocal &&
                 autoconf &&
                 automake &&
                 autoheader) || die "Error reconfiguring $dir"
            done
        fi
}

do_avr32_configure_bfd () {
        if test ${TARGET_ARCH} == avr32; then
            (cd ${B} && make configure-bfd) || die "Error running 'make configure-bfd'"
            (cd ${B}/bfd && make headers) || die "Error running 'make headers'"
        fi
}

addtask avr32_reconf after do_patch before do_configure
addtask avr32_configure_bfd after do_configure before do_compile
          
