DESCRIPTION = "i2c init file and command line tool"
SECTION = "base"
PRIORITY = "required"
PR = "r3"

SRC_URI = " \
  file://Config.h \   
  file://Crc8.h \   
  file://Crc8.c \   
  file://DumpMem.h \   
  file://DumpMem.c \   
  file://Log.h \   
  file://Log.c \   
  file://i2c-api.h \   
  file://i2c-api.c \   
  file://i2c-dev.h \   
  file://i2c-io.h \   
  file://i2c-io-api.h \   
  file://i2c.h \   
  file://i2c.c \   
  file://i2c.init \   
  "

S = "${WORKDIR}"

do_compile () {
	${CC} ${LDFLAGS} -o i2c *.c
}

do_install () {
  install -d ${D}${bindir}/
	install -m 0755 ${WORKDIR}/i2c ${D}${bindir}/

	install -d ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/i2c.init ${D}${sysconfdir}/init.d/i2c
}

inherit update-rc.d
INITSCRIPT_NAME = "i2c"
INITSCRIPT_PARAMS = "defaults 90"

PACKAGES = "${PN}"
FILES_${PN}  = "${bindir}/*"
FILES_${PN} += "${sysconfdir}/*"

