DESCRIPTION = "CPU burn app that loads the NEON coprocessor fully"
LICENSE = "MIT"

SRC_URI = "http://hardwarebug.org/files/burn.S"

S = "${WORKDIR}"

do_compile() {
	${CC} ${CFLAGS} ${LDFLAGS} burn.S -o burn
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/burn ${D}${bindir}/burn-neon
}
# only for ARM systems infact it should check for MACHINE_FEATURE 
# neon or something. For now we spare non arm arches from picking this up

COMPATIBLE_HOST = "arm.*"

SRC_URI[md5sum] = "823abc72c2cd448e87df9bc5355a4456"
SRC_URI[sha256sum] = "01d9fc04f83740c513c25401dcc89c11b2a5a6013e70bfca42b7b02129f88cd2"

