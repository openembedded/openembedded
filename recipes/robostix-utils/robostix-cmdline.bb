DESCRIPTION = "robostix programs"
SECTION = "base"
PRIORITY = "required"
PR = "r1"

DEPENDS = robostix-module

SRC_URI = " \
   file://robostix.h \
   file://robostix.c \
  "

CMD_NAME=robostix

S = "${WORKDIR}"

do_compile () {
	${CC} -o ${CMD_NAME} *.c
}

do_install () {
  install -d ${D}${bindir}/
	install -m 0755 ${WORKDIR}/${CMD_NAME} ${D}${bindir}/
}

PACKAGES = "${PN}"
FILES_${PN} = "${bindir}/*"

