DESCRIPTION = "Openslug initial network config via sysconf"
SECTION = "console/network"
LICENSE = "GPL"
DEPENDS = "base-files"
PR = "r3"

SRC_URI = "file://sysconfsetup \
	   file://kern_header.c"

inherit autotools update-rc.d

INITSCRIPT_NAME = "sysconfsetup"
INITSCRIPT_PARAMS = "defaults 39"

do_compile() {
	${CC} -o ${S}/../kern_header ${S}/../kern_header.c
}

do_install() {
        install -d ${D}/${sysconfdir} \
                   ${D}/${sysconfdir}/init.d \
                   ${D}/${sysconfdir}/rcS.d \
		   ${D}/${sbindir} 
		  
	install -d ${D}/initrd

	install -m 0755 ${D}/../kern_header ${D}/${sbindir}/kern_header
	install -m 0755 ${D}/../sysconfsetup ${D}/${sysconfdir}/init.d/
	ln  -s /etc/init.d/sysconfsetup ${D}/${sysconfdir}/rcS.d/S39sysconfsetup
}
