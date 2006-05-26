include xmame_${PV}.bb

DESCRIPTION = "Multiple Arcade Machine Emulator based on SDL (tiny version)"
TINY = 1
SRC_URI += " file://tiny.mak"

do_compile_prepend () {
	cp ${WORKDIR}/tiny.mak ${S}/src/mame.mak
}
