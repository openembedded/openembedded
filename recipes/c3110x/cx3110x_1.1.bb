DESCRIPTION = "cx3110x wifi support as found in the Nokia 770/800"
SECTION = "kernel/modules"
LICENSE = "GPL"
PR = "r4"

COMPATIBLE_MACHINE = "(nokia770|nokia800)"

export KERNEL_SRC_DIR = ${STAGING_KERNEL_DIR}
export LDFLAGS = ""

SRC_URI = "https://garage.maemo.org/frs/download.php/939/cx3110x-1.1.tar.gz \
           file://umac_binary.patch;patch=1 \
           http://use.the.umac.ko.from.your.own.nokia800/umac.ko" 

S = "${WORKDIR}/cx3110x-${PV}"

inherit module

do_compile() {
	cp ${WORKDIR}/umac.ko ${S}/src/binary_umac.o
	${OBJCOPY} ${S}/src/binary_umac.o -R __ksymtab
	${OBJCOPY} ${S}/src/binary_umac.o -R __ksymtab_strings
	${OBJCOPY} ${S}/src/binary_umac.o -R .gnu.linkonce.this_module
	${OBJCOPY} ${S}/src/binary_umac.o -R .modinfo
	${OBJCOPY} ${S}/src/binary_umac.o -R .init.text
	${OBJCOPY} ${S}/src/binary_umac.o -R .exit.text

	oe_runmake modules 
}


SRC_URI[md5sum] = "18e5dc522aa9424cf9b32b86da19b85e"
SRC_URI[sha256sum] = "b0e00a7c164711512549d3ad82707c53a20fd978c2448ec22d2ea76df1954eee"
