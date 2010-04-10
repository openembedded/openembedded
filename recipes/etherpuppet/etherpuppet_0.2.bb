DESCRIPTION = "Etherpuppet is a small program for Linux that will create a \
voodoo doll for an Ethernet interface. You have to run the Etherpuppet on \
your machine to create the doll, which will have the shape of a virtual \
TUN/TAP interface (named by default puppet%d, where %d is a number). \
You also have to run Etherpuppet on the victim interface's machine."
SECTION = "console/network"
LICENSE = "LGPL"

SRC_URI = "http://www.secdev.org/projects/etherpuppet/files/etherpuppet.c"
S = "${WORKDIR}"

do_unpack() {
	install -m 0644 ${DL_DIR}/etherpuppet.c ${S}
}

do_compile() {
	${CC} ${CFLAGS} ${LFLAGS} -o etherpuppet etherpuppet.c
}

do_install() {
	install -d ${D}${sbindir}
	install -m 0755 etherpuppet ${D}${sbindir}
}


SRC_URI[md5sum] = "6180d3a7001e528e0f87d258116ee1c9"
SRC_URI[sha256sum] = "71416d34294c584cf9e8b9b4d72a34ed412b94f9928010891e786fe7b0cd98c9"
