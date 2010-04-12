require xmame_${PV}.bb

DESCRIPTION = "Multiple Arcade Machine Emulator based on SDL (tiny version)"
TINY = "1"
SRC_URI += " file://tiny.mak"

do_compile_prepend () {
	cp ${WORKDIR}/tiny.mak ${S}/src/mame.mak
}

SRC_URI[md5sum] = "c289797531d540853c835a2bb9fad8bc"
SRC_URI[sha256sum] = "7cceeadeab80f605ed1fba47feb9fd1736d08626ba3f5374dfbe55659232cdd3"
