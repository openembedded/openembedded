# Perform tasks required to use Atmel's AVR32 patches
# See http://avr32linux.org/twiki/bin/view/Main/GDBPatches for more info


do_avr32_reconf () {
    if test ${TARGET_ARCH} == "avr32"; then
        (cd ${S} && autoconf) || \
            die "failure running autoconf in top-level gdb"

        (cd ${S}/bfd && autoreconf) || \
            die "failure running autoreconf in bfd/"

        (cd ${S}/opcodes && autoreconf) || \
            die "failure running autoreconf in opcodes/"
    fi

}



do_avr32_configure_bfd () {
    if test ${TARGET_ARCH} == "avr32"; then
        (cd ${B} && make configure-bfd) || die "Error running configure-bfd"
        (cd ${B}/bfd && make headers) || \
                die "error running 'make headers' in bfd"
    fi
}


addtask avr32_reconf after do_patch before do_configure
addtask avr32_configure_bfd after do_configure before do_compile

