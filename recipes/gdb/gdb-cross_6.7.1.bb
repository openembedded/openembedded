require gdb-cross.inc
LICENSE = "GPLv3"

inherit cross

DEFAULT_PREFERENCE_avr32 = "99"
SRC_URI_avr32 = " http://avr32linux.org/twiki/pub/Main/GDBPatches/gdb-6.7.1.atmel.1.0.3.tar.bz2"
S_avr32 = "${WORKDIR}/gdb-6.7.1.atmel.1.0.3"

do_configure_prepend() {
    for i in $(find ${S} -name "warning*m4") ; do
        sed -i -e s:-Werror::g $i
    done
    for i in $(find ${S} -name "configure.ac") ; do
        sed -i -e s:-Werror::g $i
    done
    for i in $(find ${S} -name "configure") ; do
        sed -i -e s:-Werror::g $i
    done
}

